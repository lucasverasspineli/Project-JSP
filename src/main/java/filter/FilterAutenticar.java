package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnectionBank;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/principal/*" })
public class FilterAutenticar implements Filter {

	private static Connection connection;

	public FilterAutenticar() {

	}

	// Encerrar o processo de conexão com o banco, quando o servidor for parado.
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			String usuarioLog = (String) session.getAttribute("usuario");
			String urlAuth = req.getServletPath();

			if (usuarioLog == null && !urlAuth.equalsIgnoreCase("/principal/ServletLogin")) {

				RequestDispatcher redirec = request.getRequestDispatcher("/index.jsp?url=" + urlAuth);
				request.setAttribute("msg", "Por favor realize o Login!");
				redirec.forward(req, response);
				return;

			} else {
				chain.doFilter(request, response);
			}

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// Iniciando a conexão com banco quando o servidor for iniciado.
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBank.getConnection();

	}

}
