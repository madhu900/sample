import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementEx2 {

	public static void main(String[] args) {
		
		Connection connection=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc1","root","root");
			statement=connection.createStatement();
			String query="delete from user where id=6";
			
			int numberOfRecordsDelete=statement.executeUpdate(query);
			System.out.println(numberOfRecordsDelete);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
