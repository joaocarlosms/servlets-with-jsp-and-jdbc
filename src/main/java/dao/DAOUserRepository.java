package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnectionDatabase;
import model.ModelLogin;

public class DAOUserRepository {
	
	private Connection connection;
	
	public DAOUserRepository() {
		connection = SingleConnectionDatabase.getConnection();
	}
	
	public void saveUser(ModelLogin obj) throws Exception {
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
	}
}
