package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbuser = "hr";
		String dbpass = "hr";
		
		// Connection, Statement, ResultSet
		Connection conn = null;	
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);	
			stmt = conn.createStatement();
			rs = null;
				 
			String sql = "SELECT department_id, department_name FROM departments";
			
			rs = stmt.executeQuery(sql);		//	DB Cursor 반활
			
			//	ResultSet 순회
			while (rs.next()) {
				// getXXX(컬럼 순서) or getXXX(컬럼 프로젝션 이름) 
				int deptId = rs.getInt(1);	// rs.getInt("department_id")
				String deptName = rs.getString("department_name"); // rs.getStirng(2)
				
				System.out.printf("%d:%s%n", deptId, deptName);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버를 로드하지 못했습니다.");
		} catch (SQLException e) {
			System.err.println("SQLError!");
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				
			}
			try {
				stmt.close();
			} catch (Exception e) {
				
			}
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}

	}

}
