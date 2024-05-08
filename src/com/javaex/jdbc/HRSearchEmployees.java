package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class HRSearchEmployees {
	public static void main(String[] args) {
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbuser = "hr";
		String dbpass = "hr";

		// Connection, Statement, ResultSet

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Scanner scanner = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);

			System.out.print("검색어를 입력하세요:");
			String keyword = scanner.next();

			stmt = conn.createStatement();

			String sql = "SELECT first_name || ' ' || last_name, email, phone_number, hire_date "
					+ "FROM employees WHERE lower(first_name) LIKE '%" + keyword.toLowerCase() + "%' "
					+ "OR lower(last_name) LIKE '%" + keyword.toLowerCase() + "%'";
			System.out.println("Query:" + sql);

			rs = stmt.executeQuery(sql); // DB Cursor 반환

			// ResultSet 순회
			while (rs.next()) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				String phoneNumber = rs.getString(3);
				Date hireDate = rs.getDate(4);

				System.out.printf("%s: %s, %s, %s%n", name, email, phoneNumber, hireDate);
			}

		} catch (ClassNotFoundException e) {
			System.err.println("드라이버를 로드하지 못했습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQLError!");
			e.printStackTrace();
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

		scanner.close();
	}

}