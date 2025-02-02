package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionDatabase;
import model.ModelLogin;

public class DAOUserRepository {
	
	private Connection connection;
	
	public DAOUserRepository() {
		connection = SingleConnectionDatabase.getConnection();
	}
	
	public ModelLogin saveUser(ModelLogin obj) throws Exception {
		String sql = "INSERT INTO public.model_login(login, password, nome, email) "
				+ "VALUES (?, ?, ?, ?);";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, obj.getLogin());
		statement.setString(2, obj.getPassword());
		statement.setString(3, obj.getNome());
		statement.setString(4, obj.getEmail());
		
		statement.execute();
		connection.commit();
		
		System.out.println(obj.getNome()+" saved with success!");
		
		return this.findUserByLogin(obj.getLogin());
	}
	
	public ModelLogin findUserByLogin(String login) throws Exception {
		ModelLogin modelLogin = new ModelLogin();
		
		String sql = "SELECT * FROM public.model_login WHERE UPPER(login) = UPPER('"+login+"')";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			modelLogin.setId(result.getLong("id"));
			modelLogin.setLogin(result.getString("login"));
			modelLogin.setPassword(result.getString("password"));
			modelLogin.setEmail(result.getString("email"));
			modelLogin.setNome(result.getString("nome"));
		}
		
		return modelLogin;
	}
	
	public boolean validateUserByLogin(String login) throws Exception {
		String sql = "SELECT COUNT(1) > 0 AS existe FROM public.model_login WHERE UPPER(login) = UPPER(?);";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		ResultSet result = statement.executeQuery();
		
		result.next();
		return result.getBoolean("existe");
	}
	
//	public ModelLogin updateUserByLogin(String id) {
//		
//	}
	
}
