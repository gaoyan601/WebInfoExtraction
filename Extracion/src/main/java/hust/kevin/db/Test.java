package hust.kevin.db;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		MySql mysql =  new MySql("ibm","Hust-Ibm","218.199.92.27.","scgov");
		Connection conn;
		try {
			conn =  mysql.getConnection();
			System.out.println(conn.isClosed());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		mysql.close();
		
		try {
			System.out.println(conn.isClosed());
			conn =  mysql.getConnection();
			System.out.println(conn.isClosed());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
}
