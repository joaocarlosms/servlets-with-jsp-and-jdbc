package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;

@javax.servlet.annotation.WebServlet("/test/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {

    }
    
    /*Recebe os dados da URL em parametros*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/*Recebe dados enviados pelo formulário*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if(login != null && !login.isEmpty() 
				&& password != null && !password.isEmpty()) {
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setPassword(password);
			System.out.println("Login with success!");
			
		} else {
			System.out.println("DADOS VAZIOS");
			RequestDispatcher redirect = request.getRequestDispatcher("/"); 
			request.setAttribute("msg", "Informe o login e a senha corretamente!");
			redirect.forward(request, response);
		}
	}
}
  