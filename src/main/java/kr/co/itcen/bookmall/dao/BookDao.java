package kr.co.itcen.bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.Vo;

public class BookDao extends Dao{

	@Override
	public List<Vo> getList() {
		List<Vo> result = new ArrayList<Vo>();

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "select * from book";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				int categoryNo = rs.getInt("category_no");

				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategoryNo(categoryNo);

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
		BookVo bvo = (BookVo)vo;

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "insert into book(no, title, price, category_no) values(null,?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, bvo.getTitle());
			pstmt.setInt(2, bvo.getPrice());
			pstmt.setInt(3, bvo.getCategoryNo());

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
			String sql = "delete from book";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			int rows = pstmt.executeUpdate();
			
			sql = "alter table book auto_increment = 1";
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
		return "--------------------Book----------------------";
	}
	
	

}
