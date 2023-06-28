package filter;

import java.io.IOException;

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

@WebFilter(urlPatterns = {"/principal/*"})
public class FilterAutenticar implements Filter {
    public FilterAutenticar() {
    	
    }

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLog = (String) session.getAttribute("usuario");
		String urlAuth = req.getServletPath();
		
		if(usuarioLog == null || (usuarioLog != null && usuarioLog.isEmpty()) && !urlAuth.contains("/principal/ServletLogin")) {
			
			RequestDispatcher redirec = request.getRequestDispatcher("/index.jsp?url=" + urlAuth);
			request.setAttribute("msg","Por favor realize o Login!");
			redirec.forward(req, response);
			return;
			
		} else {
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		

	}

}
