package student_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student_me{
	
	public static boolean createTable() {
		Connection con=CreateConnection.createConnection();
		String query="Create table if not exists student2(id int, name varchar(30), mobileno int)";
		boolean result=false;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			con.close();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static boolean insertRecord(Student st) {
		Connection c=CreateConnection.createConnection();
		boolean result=false;
		try {
			
			String query="insert into student(name,city,mail,mob) values(?,?,?,?)";
			PreparedStatement pstmt=c.prepareStatement(query);
			pstmt.setString(1,st.getName());
			pstmt.setString(2, st.getCity());
			pstmt.setString(3, st.getMail());
			pstmt.setString(4, st.getMob());
			
			pstmt.executeUpdate();
			result=true;
			c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return(result);
		
	}
	
	public static void displayRecord() {
		try {
			Connection c=CreateConnection.createConnection();
			
			String query = "Select * from student";
			PreparedStatement pstmt=c.prepareStatement(query);
			ResultSet resultSet = pstmt.executeQuery();
			
			System.out.println("id\t\t"+"name\t\t"+"city\t\t"+"mail\t\t\t"+"mob");
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String nameString = resultSet.getString(2);
				String cityString = resultSet.getString(3);
				String mailString = resultSet.getString(4);
				String mobString = resultSet.getString(5);
				
				System.out.println(id+"\t\t"+nameString+"\t\t"+cityString+"\t\t"+mailString+"\t\t"+mobString);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean updateRecord(Student st, int id) {
		boolean result = false;
		try {
			Connection c=CreateConnection.createConnection();
			int newid=id;
			String query="Update student SET name=?, city=?, mail=?, mob=? where id=?";
			PreparedStatement pstmt=c.prepareStatement(query);
			
			pstmt.setString(1,st.getName());
			pstmt.setString(2, st.getCity());
			pstmt.setString(3, st.getMail());
			pstmt.setString(4, st.getMob());
			pstmt.setInt(5, newid);
			
			pstmt.executeUpdate();
			result=true;
			c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean deleteRecord(int id) {
		boolean result=false;
		
		try {
			Connection c=CreateConnection.createConnection();
			String query="Delete from student where id=?";
			
			PreparedStatement pstmt=c.prepareStatement(query);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			result=true;
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return(result);
	}
}
