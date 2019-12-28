
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementInsertExample2 {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc3", "root", "root");

			statement = connection.createStatement();

			String query = "INSERT INTO USER (username, PASSWORD) VALUES ('admin6', 'pwd1')";
			
			int numOfRecAff = statement.executeUpdate(query);
			System.out.println(numOfRecAff);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
