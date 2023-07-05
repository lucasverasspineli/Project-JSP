package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

@WebServlet(urlPatterns = { "/principal/ServletLogin" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("Login");
		String senha = request.getParameter("Senha");
		String url = request.getParameter("url");

		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);

			if (modelLogin.getLogin().equalsIgnoreCase("admin") && modelLogin.getSenha().equalsIgnoreCase("admin")) {
				request.getSession().setAttribute("usuario", modelLogin.getLogin());

				if (url == null || url.equals("null")) {
					url = "principal/Principal.jsp";
				}
				RequestDispatcher redirec = request.getRequestDispatcher(url);
				redirec.forward(request, response);

			} else { // o /index.jsp serve para ele voltar para página, para voltar para o index!
				RequestDispatcher redirec = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Informou o login e senha errado");
				redirec.forward(request, response);
			}

		} else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe o Login e a Senha corretamente");
			redirecionar.forward(request, response);

		}

	}

}
