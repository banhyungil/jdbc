package kr.co.itcen.bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.Vo;

public class CategoryDao extends Dao{

	@Override
	public List<Vo> getList() {
		List<Vo> result = new ArrayList<Vo>();

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "select * from category";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				CategoryVo vo = new CategoryVo();

				vo.setName(name);
				vo.setNo(no);
				
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
		// TODO Auto-generated method stub
		CategoryVo cvo = (CategoryVo)vo;
		
		try {

			connection();

			//3. Statement 객체 생성
			String sql = "insert into category(no,name) values(null,?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, cvo.getName());
		
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
			String sql = "delete from category";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			int rows = pstmt.executeUpdate();
			
			sql = "alter table category auto_increment = 1";
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
		return "--------------------Category----------------------";
	}
}
