import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMain {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/Fer_jdbc","root","root");
			statement=connection.prepareStatement("select * from user where username=? and password=?");
			
			statement.setString(1,"madhu");
			statement.setString(2,"madhu");
			
			ResultSet resultset=statement.executeQuery();
			
	
			while(resultset.next()) {
				int id=resultset.getInt(1);
				String firstname=resultset.getString(2);
				String middlename=resultset.getString(3);
				String lastname=resultset.getString(4);
				String username=resultset.getString(5);
				String password=resultset.getString(6);
				String email=resultset.getString(7);
				String mobile=resultset.getString(8);
				
				System.out.println(id+", "+firstname+", "+middlename+", "+lastname+", "+username+", "+password+", "+email+", "+mobile);
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


