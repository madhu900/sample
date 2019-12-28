import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetPasswordMain {

	public static void main(String[] args) {
	
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/Fer_jdbc","root","root");
			statement=connection.prepareStatement("update user set password=? where id=? and password=?");
		
				statement.setString(1,"sudhan");
		
			int numberOfRecordUpdated=statement.executeUpdate();
			System.out.println("no of records updated:"+numberOfRecordUpdated);
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


