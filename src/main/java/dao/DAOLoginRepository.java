package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBank;
import model.ModelLogin;

public class DAOLoginRepository {

	private Connection connection;

	public DAOLoginRepository() {
		connection = SingleConnectionBank.getConnection();
	}

	public boolean validAuth(ModelLogin modelLogin) throws SQLException {
		
		String sql = "Select * from model_login where upper(login) = upper(?) and upper(senha) = upper(?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
		
		ResultSet result = statement.executeQuery();
		//Validação se houver esse Login e Senha no banco
		if(result.next()) {
			return true;
		}
		
		return false;
	}

}
