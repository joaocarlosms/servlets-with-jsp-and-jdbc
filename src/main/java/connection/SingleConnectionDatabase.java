package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionDatabase {
	private static String database = "jdbc:postgresql://localhost:5432/cursojsp?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	/*Toda vez que for instanciada essa class
	 * o construtor static vai rodar antes de tudo
	 * garantindo a conexão, mas caso de algum erro, 
	 * ele irá passar pelo construtor e realizar a
	 * conexão com o database*/
	static {
		connect();
	}
	
	public SingleConnectionDatabase() {
		connect();
	}
	
	public static void connect() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver"); /*Carrega o drive de conexao do banco*/
				connection = DriverManager.getConnection(database, user, password);
				connection.setAutoCommit(false); /*para efetuar alterações no banco sem nosso comando*/
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
