import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class JdbcPreparedStatementEx {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc1","root","root");
			statement=connection.prepareStatement("insert into user (username,password)values(?,?)");
			
			for(int index=1;index<101;index++) {
				statement.setString(1,"user"+index);
				statement.setString(2,"hsdkd");
				
				statement.addBatch();
			}
			
			int[] numberOfRecordInserted=statement.executeBatch();
			System.out.println("no of records inserted:"+numberOfRecordInserted);
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
		

	


