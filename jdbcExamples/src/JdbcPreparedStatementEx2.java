import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPreparedStatementEx2 {

	public static void main(String[] args) {
	
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc1","root","root");
			statement=connection.prepareStatement("select * from user where username=? and password=?");
			
			statement.setString(1,"madhuk12");
			statement.setString(2,"abcd' OR '1=1");
			
			ResultSet resultset=statement.executeQuery();
			
	
			while(resultset.next()) {
				int id=resultset.getInt(1);
				String username=resultset.getString(2);
				String password=resultset.getString(3);
				String salary=resultset.getString(4);
				String department=resultset.getString(5);
				
				System.out.println(id+", "+username+", "+password+", "+salary+" and "+department);
			}
			
			
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


