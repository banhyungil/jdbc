package kr.co.itcen.bookmall.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartOrderBookVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.Vo;

public class CartOrderBookDao extends Dao{

	@Override
	public List<Vo> getList() {
		List<Vo> result = new ArrayList<Vo>();

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "select * from cart_order_book";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			rs = pstmt.executeQuery();

			while(rs.next()) {				
				int bookNo = rs.getInt("book_no");
				int no = rs.getInt("no");
				String orderDate = rs.getString("order_date");
				int quantity = rs.getInt("quantity");
				int userNo = rs.getInt("user_no");

				CartOrderBookVo vo = new CartOrderBookVo();

				vo.setBookNo(bookNo);
				vo.setNo(no);
				vo.setOrderDate(orderDate);
				vo.setQuantity(quantity);
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
		CartOrderBookVo cobvo = (CartOrderBookVo)vo;

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "insert into cart_order_book(no,quantity, order_date, book_no, user_no) values(null,?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, cobvo.getQuantity());
			pstmt.setDate(2, Date.valueOf("1993-12-09"));
			pstmt.setInt(3, cobvo.getBookNo());
			pstmt.setInt(4, cobvo.getUserNo());
	
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
			String sql = "delete from cart_order_book";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			int rows = pstmt.executeUpdate();
			
			sql = "alter table cart_order_book auto_increment = 1";
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
		return "--------------------CartOrderBook----------------------";
	}

}
