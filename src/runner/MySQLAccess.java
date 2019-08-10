package runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost";
	final private String user = "root";
	final private String pass = "";
	
	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/testpegadaian", user, pass);
			statement = connection.createStatement();

			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from min_maks");
			writeResultSet(resultSet);

			// PreparedStatements can use variables and are more efficient
			preparedStatement = connection.prepareStatement("insert into min_maks (input, maksimal, minimal) values (?,?,?)");
			preparedStatement.setString(1, "test");
			preparedStatement.setInt(2, 10);
			preparedStatement.setInt(3, 1);

			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement("SELECT input, maksimal, minimal from min_maks");
			resultSet = preparedStatement.executeQuery();
			writeResultSet(resultSet);

//			// Remove again the insert comment
//			preparedStatement = connection.prepareStatement("delete from feedback.comments where myuser= ? ; ");
//			preparedStatement.setString(1, "Test");
//			preparedStatement.executeUpdate();

			resultSet = statement.executeQuery("select * from min_maks");
			writeMetaData(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	private void writeMetaData(ResultSet resultSet) throws SQLException {
		// Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String input = resultSet.getString("input");
			String maksimal = String.valueOf(resultSet.getInt("maksimal"));
			String minimal = String.valueOf(resultSet.getInt("minimal"));
			System.out.println(input);
			System.out.println(maksimal);
			System.out.println(minimal);
		}
	}

	// You need to close the resultSet
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
