import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPreparedStatementEx4 {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc1","root","root");
			statement=connection.prepareStatement("delete from user");
			
				statement.addBatch();
	
			int[] numberOfRecordDeleted=statement.executeBatch();
			System.out.println("no of records deleted:"+numberOfRecordDeleted);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
				
			}
		}

				
				
			
		

	

	




	}


