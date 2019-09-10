package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mariadb://192.168.1.42:3306/webdb?characterEncoding=utf8";
		String uID = "webdb";
		String uPW = "webdb";
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1. JDBC Driver를 로딩
			//Class들의 대부분은 미리 JVM에 load가 되어있다.
			//로딩을 수작업으로 하는 이유는 class가 loading되는 작업외에 진행되는 작업이 존재해서 이다.
			Class.forName("org.mariadb.jdbc.Driver");		//Class Loading


			//2. 연결하기
			connection = DriverManager.getConnection(url, uID, uPW);

			System.out.println("연결성공");

			//3. Statement 객체 생성
			stmt = connection.createStatement();

			//4. SQL문 실행
			String sql = "select * from department";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Integer no = rs.getInt("no");
				String name = rs.getString("name");
				System.out.println("no : " + no + " name : " + name);
			}

		} catch (ClassNotFoundException e) {				//Class가 없으면
			// TODO Auto-generated catch block
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(connection != null) 
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


