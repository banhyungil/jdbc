package kr.co.itcen.bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.OrderBookVo;
import kr.co.itcen.bookmall.vo.Vo;

public class OrderBookDao extends Dao{

	@Override
	public List<Vo> getList() {
		List<Vo> result = new ArrayList<Vo>();

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "select * from order_book";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int no = rs.getInt("no");
				int quantity = rs.getInt("quantity");
				int orderNo = rs.getInt("order_no");
				int bookNo = rs.getInt("book_no");

				OrderBookVo vo = new OrderBookVo();

				vo.setNo(no);
				vo.setQuantity(quantity);
				vo.setBookNo(bookNo);
				vo.setOrderNo(orderNo);

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
		OrderBookVo obvo = (OrderBookVo)vo;

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "insert into order_book(no,quantity, order_no, book_no) values(null,?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, obvo.getQuantity());
			pstmt.setInt(2, obvo.getOrderNo());
			pstmt.setInt(3, obvo.getBookNo());
			
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
			String sql = "delete from order_book";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			int rows = pstmt.executeUpdate();
			
			sql = "alter table order_book auto_increment = 1";
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
		return "--------------------OrderBook----------------------";
	}
}
