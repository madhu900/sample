import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/Fer_jdbc", "root", "root");
			statement = connection.prepareStatement(
					"insert into user (firstname,middlename,lastname,username,password,email,mobile)values(?,?,?,?,?,?,?)");

			statement.setString(1, "madhu");
			statement.setString(2, "sudhan");
			statement.setString(3, "kamireddy");
			statement.setString(4, "madhu");
			statement.setString(5, "madhu");
			statement.setString(6, "email");
			statement.setString(7, "45667956");

		//	statement.addBatch();

			int numberOfRecordInserted = statement.executeUpdate();
			System.out.println("no of records inserted:" + numberOfRecordInserted);
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
