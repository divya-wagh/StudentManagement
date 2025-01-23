package student_management;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	static Connection con;
	
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Diva19@7@03");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
