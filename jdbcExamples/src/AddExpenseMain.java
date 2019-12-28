import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddExpenseMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/Fer_jdbc", "root", "root");
			statement = connection.prepareStatement(
					"insert into expense (expensetype,date,price,noofitems,total,bywhom)values(?,?,?,?,?,?)");
//statement("");
			statement.setString(1, "type1");
			statement.setString(2, "2019-11-26");
			statement.setString(3, "1000");
			statement.setString(4, "1");
			statement.setString(5, "1");
			statement.setString(6, "madhu");

			//statement.addBatch();

			int numberOfRecordInserted = statement.executeUpdate();
			System.out.println("");
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
