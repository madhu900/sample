import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementEx {

	public static void main(String[] args) {
	
		Connection connection= null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc1","root","root");
			
			
			for(int index=1; index<101; index++) {
				statement=connection.createStatement();
			
				String query="insert into user(username,password)values('admin"+index+"','pwd1')";
			
				int numberOfRecordsInsert=statement.executeUpdate(query);
				System.out.println(numberOfRecordsInsert);
				
				statement.close();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}

		
			
			
			
	



