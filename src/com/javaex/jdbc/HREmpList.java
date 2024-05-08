package com.javaex.jdbc;

import java.sql.*;

public class HREmpList {
    public static void main(String[] args) {
        // 데이터베이스 접속 정보
        String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; // DB URL
        String dbuser = "hr"; // DB 사용자명
        String dbpass = "hr"; // DB 패스워드
        
        

        // 데이터 베이스 연결
        try {
            // 데이터 베이스 드라이버 클래스 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(dburl, dbuser, dbpass);

            // 쿼리 실행
            Statement statement = connection.createStatement();
            String sql = "SELECT e.first_name || ' ' || e.last_name 이름,"+
                    "mgr.first_name || ' ' || mgr.last_name 매니저이름 "+
                    "FROM employees e join employees mgr on mgr.employee_id = e.manager_id "+
                    "ORDER BY 이름 DESC";
            ResultSet resultSet = statement.executeQuery(sql);

            // 결과 출력
            int count = 0;
            while (resultSet.next()) {
                String eName = resultSet.getString(1);
                String mName = resultSet.getString(2);
                System.out.println("Name:"+ eName + " MName:"+ mName);
                count++;
            }
            System.out.println("count: " + count);

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