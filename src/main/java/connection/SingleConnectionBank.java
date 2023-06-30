package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBank {

	private static String db = "jdbc:postgresql://localhost:5432/project-jsp?autoReconnect=true";
	private static String user = "postgres"; 
	private static String password = "admin";
	private static Connection connection = null;
	
	// Invocando a classe diretamente.
	static {
		connect();
	}
	
	public SingleConnectionBank() {
		connect();
	}
	
	private static void connect() {
		try {
				if(connection == null) {
					Class.forName("org.postgresql.Driver");
					connection = DriverManager.getConnection(db, user, password);
					connection.setAutoCommit(false);//Para não fazer Update no banco automaticamente!
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
	
	
	
}
