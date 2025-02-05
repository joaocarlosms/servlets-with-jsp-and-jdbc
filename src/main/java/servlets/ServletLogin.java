package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dao.DAOLoginRepository;
import model.ModelLogin;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/ServletLogin", "/principal/ServletLogin"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();;

	public ServletLogin() {
    	super();
    }
    
    /*Recebe os dados da URL em parametros*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action != null && !action.isEmpty() && action.equalsIgnoreCase("logout")) {
			request.getSession().invalidate();
			RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp");
			redirect.forward(request, response);
			
		} else {
			doPost(request, response);
		}
	}

	/*Recebe dados enviados pelo formulário*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
		
		System.out.println(login);
		System.out.println(password);
		
		try {
			
			if(login != null && !login.isEmpty() 
					&& password != null && !password.isEmpty()) {
				
				ModelLogin modelLogin = new ModelLogin();
				modelLogin.setLogin(login);
				modelLogin.setPassword(password);
				
				if(daoLoginRepository.validateAuthentication(modelLogin)) {
					request.getSession().setAttribute("user", modelLogin.getLogin());
										
					if(url == null || url.equals("null")) {
						url = "/principal/principal.jsp";
					}
					
					System.out.println(url);
					RequestDispatcher redirect = request.getRequestDispatcher(url);
					redirect.forward(request, response);	
					
				} else {
					RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp"); 
					request.setAttribute("msg", "Login e/ou Senha incorreto(s)!");
					redirect.forward(request, response);
				}
				
			} else {
				RequestDispatcher redirect = request.getRequestDispatcher("/"); 
				request.setAttribute("msg", "Informe o login e a senha corretamente!");
				redirect.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher redirect = request.getRequestDispatcher("/erros.jsp"); 
			request.setAttribute("msg", e.getMessage());
			redirect.forward(request, response);
		}
		
	}
}
  










