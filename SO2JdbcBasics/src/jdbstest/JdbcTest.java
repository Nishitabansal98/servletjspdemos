package jdbstest;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			
		Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","nishita@123");
		Statement statement1 = (Statement) connection1.createStatement();
		ResultSet resultSet = ((java.sql.Statement) statement1).executeQuery("select *from account");
		while(resultSet.next()) {
			   System.out.println(resultSet.getInt(1) + " , " + resultSet.getString(2) + " , " + resultSet.getString(3) + " , " +resultSet.getInt(4));
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}