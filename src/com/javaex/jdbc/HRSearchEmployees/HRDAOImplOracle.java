package com.javaex.jdbc.HRSearchEmployees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaex.jdbc.dao.AuthorVO;



public class HRDAOImplOracle implements HRDAO {
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(dburl, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASS);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버를 찾을 수 없습니다.");
		}

		return conn;

	}

	@Override
	public List<HRVO> getList() {
		List<HRVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. Connection
			conn = getConnection();
			// 2. Statement
			stmt = conn.createStatement();
			// 3. SQL 쿼리 전송 -> ResultSet
			String sql = "SELECT first_name || ' ' || last_name, email, phone_number, hire_date FROM employees";
			rs = stmt.executeQuery(sql);
			// 4. ResultSet 순회 -> 레코드를 AuthorVO로 변경
			// List에 추가
			while (rs.next()) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				String phoneNumber = rs.getString(3);
				Date hireDate = rs.getDate(4);

				HRVO vo = new HRVO(name, email, phoneNumber,hireDate);
				list.add(vo);
			}
			// 5. List를 반환

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return list;
	}

	@Override
	public HRVO get(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HRVO vo = null;
		try {
	        conn = getConnection();
	        String sql = "SELECT first_name || ' ' || last_name, email, phone_number, hire_date "
	                + "FROM employees WHERE lower(first_name) LIKE ? "
	                + "OR lower(last_name) LIKE ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + name.toLowerCase() + "%");
	        pstmt.setString(2, "%" + name.toLowerCase() + "%");
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String fullName = rs.getString(1);
	            String email = rs.getString(2);
	            String phoneNumber = rs.getString(3);
	            Date hireDate = rs.getDate(4);
	            vo = new HRVO(fullName, email, phoneNumber, hireDate);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return vo;

	
	}
}
