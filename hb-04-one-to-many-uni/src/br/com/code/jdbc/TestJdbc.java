package br.com.code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public TestJdbc() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        
    	String url = "jdbc:mysql://localhost/hb-04-one-to-many-uni?useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "hbstudent";
		String password = "hbstudent";
		
		System.out.println("Connecting to database: " + url);
		
		Connection conn = DriverManager.getConnection(url, user, password);
        
		System.out.println("Connection successfull!!!");
		
		return conn;
    }

    public static void main(String[] args) throws SQLException {
    	
        TestJdbc db = new TestJdbc();
        Connection conn = db.getConnection();
        System.out.println(conn);
    }
}
