package com.javaex.jdbc;

import java.sql.*;
import java.util.Scanner;


public class HRSalary {
    public static void main(String[] args) {
        // 데이터베이스 접속 정보
        String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; // DB URL
        String dbuser = "hr"; // DB 사용자명
        String dbpass = "hr"; // DB 패스워드
        
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("최소급여를 입력해주세요");
        int sal = sc.nextInt();
        System.out.println("최대급여를 입력해주세요");
        int sal2 = sc.nextInt();
        

        // 데이터 베이스 연결
        try {
            // 데이터 베이스 드라이버 클래스 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(dburl, dbuser, dbpass);

            // 쿼리 실행
            statement = connection.createStatement();
            String sql = "SELECT first_name || ' ' || last_name, salary" +
                    " FROM employees " +
                    "WHERE salary BETWEEN " + sal + " AND " + sal2 +
                    " ORDER BY salary ASC";
            resultSet = statement.executeQuery(sql);

            // 결과 출력
            while (resultSet.next()) {
            	String fullName = resultSet.getString(1);
                int salary = resultSet.getInt(2);
                System.out.println(fullName + "	" + salary);
            }
    
            sc.close();
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하지 못했습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQLError!");
            e.printStackTrace();
        }
    }
}