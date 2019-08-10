package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class AksesMySql {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost";
	final private String user = "root";
	final private String pass = "";

	public void writeDatabase(String input, int maks, int min) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/testpegadaian", user, pass);
			statement = connection.createStatement();
			
			preparedStatement = connection.prepareStatement("insert into min_maks (input, maksimal, minimal) values (?,?,?)");
			preparedStatement.setString(1, input);
			preparedStatement.setInt(2, maks);
			preparedStatement.setInt(3, min);
			preparedStatement.executeUpdate();
	
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public void readDatabase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/testpegadaian", user, pass);
			statement = connection.createStatement();
			
			preparedStatement = connection.prepareStatement("SELECT input, maksimal, minimal from min_maks");
			resultSet = preparedStatement.executeQuery();
			System.out.println("Array, maks, min");
			while (resultSet.next()) {
				String input = resultSet.getString("input");
				String maksimal = String.valueOf(resultSet.getInt("maksimal"));
				String minimal = String.valueOf(resultSet.getInt("minimal"));
				System.out.print(input);	System.out.print(", ");
				System.out.print(maksimal);	System.out.print(", ");
				System.out.print(minimal);	System.out.print(", ");
				System.out.println();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public void deleteDatabase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/testpegadaian", user, pass);
			statement = connection.createStatement();
			
			preparedStatement = connection.prepareStatement("DELETE from min_maks");
			preparedStatement.execute();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {

		}
	}
}
