package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionDatabase;
import model.ModelLogin;

public class DAOLoginRepository {
	private Connection connection;
	
	
	public DAOLoginRepository() {
		connection = SingleConnectionDatabase.getConnection();
	}
	
	public boolean validateAuthentication(ModelLogin modelLogin) throws Exception {
		String sql = "SELECT * FROM model_login WHERE login = ? and password = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getPassword());
		
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			return true; /*user authenticated*/
		}
		
		return false;
	}
}
