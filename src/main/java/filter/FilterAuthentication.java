package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpSession;

import connection.SingleConnectionDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Intercepta todas as requisições que vierem
 * do projeto ou mapeamento.
 */
@WebFilter(urlPatterns = {"/principal/*"})
public class FilterAuthentication extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = -9162106447131470505L;
    private static Connection connection;
    

	public FilterAuthentication() {
        super();
    }
	
	/*Encerra os processos quando o servidor é parado*/
	public void destroy() {
		try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*Intercepta as requisições e as respostas no sistema
	 * Tudo que fizer no sistema vai passar por esse filter*/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = (HttpSession)req.getSession();
			
			String userLoggedIn = (String) session.getAttribute("user");
			System.out.println(userLoggedIn);
			
			/*URL que está sendo acessada*/
			String urlToAuth = req.getServletPath();
			
			/*Validar se está logado senão redireciona
			 * para a tela de login*/
			if(userLoggedIn == null && !urlToAuth.equalsIgnoreCase("/jsp-course/test/ServletLogin")) {
				RequestDispatcher redirect = req.getRequestDispatcher("/index.jsp?url="+urlToAuth);
				req.setAttribute("msg", "Por favor realize o Login!");
				redirect.forward(req, response);
				return;
				
			} else {
				/*pass the request along the filter chain*/ 
				chain.doFilter(request, response);
			}
			
			connection.commit(); /*Comita as alterações no database caso dê tudo certo*/
		
		}catch(Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/*Inicia os processos ou recursos quando o servidor sobe o projeto*/
	public void init(FilterConfig fConfig) throws ServletException {
		SingleConnectionDatabase.connect();
		System.out.println("Connected with success!");
	}

}











