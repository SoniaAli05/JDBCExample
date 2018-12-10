  package jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	
	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/movielens";
	
	static final String USER = "root";
	static final String PASS = "Hamzah55";
	
	public void accessDB() {
		Connection conn = null;
		Statement stmt = null;
		  System.out.println("Connecting to database...");

			 try {
				conn = DriverManager.getConnection(DB_URL,  USER,  PASS);
				System.out.println("Connected");
			} catch (SQLException e) {
				 System.out.println("Not Connected.");
			}
			 System.out.println("Inserting records into the table...");
			 try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Failed");
				e.printStackTrace();
			}
			 String sql = "INSERT INTO movies VALUES (10040, 'Java', '2007-07-12')";
			 try {
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("failed");
				e.printStackTrace();
			}
			 System.out.println("Creating statement...");
			 try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 String sql2 = "SELECT id, title, release_date FROM movies";
			 ResultSet rs = null;
			try {
				rs = stmt.executeQuery(sql2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				while (rs.next()) {
				   int id = rs.getInt("id");
				   String title = rs.getString("title");
				   int release_date = rs.getInt("release_date");
				   System.out.println("ID: " + id + ", title: " + title + ", Release_date: " + release_date);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 

}
			 
			 
	

}