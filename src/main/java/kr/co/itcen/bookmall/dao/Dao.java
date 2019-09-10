package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.Vo;

public abstract class Dao {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void connection() {
		String DBName = "bookmall";
		String url = "jdbc:mariadb://192.168.1.42:3306/" + DBName + "?characterEncoding=utf8";
		String uID = "bookmall";
		String uPW = "bookmall";
		
		try {
			//1. JDBC Driver를 로딩
			//Class들의 대부분은 미리 JVM에 load가 되어있다.
			//로딩을 수작업으로 하는 이유는 class가 loading되는 작업외에 진행되는 작업이 존재해서 이다.
			Class.forName("org.mariadb.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, uID, uPW);
			
			//System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(connection != null) 
				connection.close();
			
			//System.out.println("자원해제 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public abstract List<Vo> getList();
	public abstract Vo get(int no);
	public abstract void insert(Vo vo);
	public abstract void delete();
}
