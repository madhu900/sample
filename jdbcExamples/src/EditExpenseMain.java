import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditExpenseMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/Fer_jdbc", "root", "root");
			statement = connection
					.prepareStatement("update expense set  expensetype=?,date=?,price=?,noofitems=?,total=?,bywhom=?");

			statement.setString(1, "type2");
			statement.setString(2, "2019-11-25");
			statement.setString(3, "2000");
			statement.setString(4, "2");
			statement.setString(5, "2");
			statement.setString(6, "sudhan");

			int numberOfRecordUpdated = statement.executeUpdate();
			System.out.println("no of records updated:" + numberOfRecordUpdated);
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
