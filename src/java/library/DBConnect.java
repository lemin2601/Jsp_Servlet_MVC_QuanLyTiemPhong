package library;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection instance = null;

	public static Connection getConnection() {
		Connection instance = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			instance = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/congngheweb?useUnicode=true&characterEncoding=utf-8", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(DBConnect.getConnection());
	}

}