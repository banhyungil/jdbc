package kr.co.itcen.bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.MyOrderVo;
import kr.co.itcen.bookmall.vo.Vo;

public class MyOrderDao extends Dao{

	@Override
	public List<Vo> getList() {
		List<Vo> result = new ArrayList<Vo>();

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "select * from my_order";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int no = rs.getInt("no");
				int payment = rs.getInt("payment");
				String shipTo = rs.getString("ship_to");
				String payComplete = rs.getString("pay_complete");
				String shipComplete = rs.getString("ship_complete");
				int userNo = rs.getInt("user_no");

				MyOrderVo vo = new MyOrderVo();

				vo.setNo(userNo);
				vo.setPayComplete(payComplete);
				vo.setPayment(payment);
				vo.setShipComplete(shipComplete);
				vo.setShipTo(shipTo);
				vo.setUserNo(userNo);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			close();
		}

		return result;
	}

	@Override
	public Vo get(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Vo vo) {
		MyOrderVo movo = (MyOrderVo)vo;

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "insert into my_order(no, payment, ship_to, pay_complete, ship_complete, user_no) values(null,?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, movo.getPayment());
			pstmt.setString(2, movo.getShipTo());
			pstmt.setString(3, movo.getPayComplete());
			pstmt.setString(4, movo.getShipComplete());
			pstmt.setInt(5, movo.getUserNo());

			//4. SQL문 실행		
			int rows = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			close();
		}
	}

	@Override
	public void delete() {
		try {
			connection();

			//3. Statement 객체 생성
			String sql = "delete from my_order";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			int rows = pstmt.executeUpdate();
			
			sql = "alter table my_order auto_increment = 1";
			pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			close();
		}
		
	}
	
	@Override
	public String toString() {
		return "--------------------MyOrder----------------------";
	}
}
