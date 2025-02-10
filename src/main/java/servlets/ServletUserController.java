package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOUserRepository;
import model.ModelLogin;

/**
 * Servlet implementation class ServletUserController
 */
@WebServlet("/ServletUserController")
public class ServletUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOUserRepository userRepository = new DAOUserRepository();  
	
    public ServletUserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String acao = request.getParameter("acao");
			
			if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {
				String idUser = request.getParameter("id");
				
				userRepository.deleteUserById(idUser);
				request.setAttribute("msg", "Excluído com sucesso!");
				request.getRequestDispatcher("principal/user.jsp").forward(request, response);
			
			} else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarajax")) {
				String idUser = request.getParameter("id");
				
				userRepository.deleteUserById(idUser);
				
				response.getWriter().write("Excluido com sucesso!");
				
			} else {
				request.getRequestDispatcher("principal/user.jsp").forward(request, response);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher redirect = request.getRequestDispatcher("erros.jsp");
			request.setAttribute("msg", e.getMessage());
			redirect.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String msg = "Operação realizada com sucesso!";
			
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelLogin.setNome(nome);
			modelLogin.setEmail(email);
			modelLogin.setLogin(login);
			modelLogin.setPassword(password);
			
			if(userRepository.validateUserByLogin(modelLogin.getLogin()) && modelLogin.getId() == null) {
				msg = "Já existe um usuário com o mesmo login, informe outro login";
			} else {
				if(modelLogin.isNew(modelLogin.getId())) {
					msg = "Gravado com sucesso!";
				} else {
					msg = "Atualizado com sucesso!";
				}
				
				modelLogin = userRepository.saveUser(modelLogin);
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("modelLogin", modelLogin);
			RequestDispatcher redirect = request.getRequestDispatcher("/principal/user.jsp");
			redirect.forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher redirect = request.getRequestDispatcher("erros.jsp");
			request.setAttribute("msg", e.getMessage());
			redirect.forward(request, response);
		}
	}

}
