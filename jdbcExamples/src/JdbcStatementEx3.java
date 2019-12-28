import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementEx3 {

	public static void main(String[] args) {
		

		Connection connection=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc1","root","root");
			statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("SELECT * FROM USER WHERE username='madhuk12' AND PASSWORD='user' or '1=1'");
			while(resultset.next()) {
				int id=resultset.getInt(1);
				String name=resultset.getString(3);
				String password=resultset.getString(2);
				
				String salary = resultset.getString(4);
				String department = resultset.getString(5);
				
				int id1 = resultset.getInt("id");
				String name1 = resultset.getString("username");
				String password1 = resultset.getString("password");
				
				String salary1 = resultset.getString("salary");
				String department1 = resultset.getString("department");
					
				System.out.println(id+", "+name+", "+password+", "+salary+" and "+department);
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	

}


	}


