package miniProjectOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PhoneBookDAOImpl implements PhoneBookDAO {
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbuser = "himedia";
			String dbpass = "himedia";
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버를 찾을 수 없습니다.");
		}

		return conn;

	}

	@Override
	public List<PhoneBookVO> getList() {
		List<PhoneBookVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. Connection
			conn = getConnection();
			// 2. Statement
			stmt = conn.createStatement();
			// 3. SQL 쿼리 전송 -> ResultSet
			String sql = "SELECT * FROM phone_book";
			rs = stmt.executeQuery(sql);
			// 4. ResultSet 순회 -> 레코드를 AuthorVO로 변경
			// List에 추가
			while (rs.next()) {
				Long id = rs.getLong(1); // = rs.getLong("author_id")
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);

				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
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
	public boolean insert(PhoneBookVO phoneBookVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0; // INSERT 결과 영향받은 레코드 수

		try {
			// 접속
			conn = getConnection();
			// 실행 계획 준비
			String sql = "INSERT INTO phone_book (name, hp, tel) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, phoneBookVO.getName());
			pstmt.setString(2, phoneBookVO.getHp());
			pstmt.setString(3, phoneBookVO.getTel());

			// 쿼리 수행
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
			}
		}
		return insertedCount == 1;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {}
		}
		return deletedCount == 1;
	}

	@Override
	public PhoneBookVO get(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PhoneBookVO vo = null;

		try {
			conn = getConnection();

			String sql = "SELECT * FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				Long id1 = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);

				vo = new PhoneBookVO(id1, name, hp, tel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return vo;
	}
	
	
}
