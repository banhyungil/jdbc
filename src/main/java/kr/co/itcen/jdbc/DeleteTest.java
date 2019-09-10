package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		delete(5);
	}
	
	public static boolean delete(int no) {
		String url = "jdbc:mariadb://192.168.1.42:3306/webdb?characterEncoding=utf8";
		String uID = "webdb";
		String uPW = "webdb";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean result = false;
		try {
			//1. JDBC Driver를 로딩
			//Class들의 대부분은 미리 JVM에 load가 되어있다.
			//로딩을 수작업으로 하는 이유는 class가 loading되는 작업외에 진행되는 작업이 존재해서 이다.
			Class.forName("org.mariadb.jdbc.Driver");		//Class Loading


			//2. 연결하기
			connection = DriverManager.getConnection(url, uID, uPW);

			System.out.println("연결성공");

			//3. PrepareStatement 객체 생성
			String sql = "delete from department where no = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, no);

			//4. SQL문 실행
			
			int count = pstmt.executeUpdate();
			
			result = (count >= 1);

		} catch (ClassNotFoundException e) {				//Class가 없으면
			// TODO Auto-generated catch block
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(connection != null) 
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
