package kr.co.itcen.bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.UserVo;
import kr.co.itcen.bookmall.vo.Vo;

public class UserDao extends Dao{

	@Override
	public List<Vo> getList() {
		List<Vo> result = new ArrayList<Vo>();

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "select * from user";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phoneNum = rs.getString("phone_num");
				String email = rs.getString("email");
				String address = rs.getString("address");

				UserVo vo = new UserVo();

				vo.setAddress(address);
				vo.setEmail(email);
				vo.setId(id);
				vo.setName(name);
				vo.setNo(no);
				vo.setPassword(password);
				vo.setPhoneNum(phoneNum);

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
		UserVo uvo = (UserVo)vo;

		try {

			connection();

			//3. Statement 객체 생성
			String sql = "insert into user(no, id, password, name, phone_num, email, address) values(null, ?, ?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, uvo.getId());
			pstmt.setString(2, uvo.getPassword());
			pstmt.setString(3, uvo.getName());
			pstmt.setString(4, uvo.getPhoneNum());
			pstmt.setString(5, uvo.getEmail());
			pstmt.setString(6, uvo.getAddress());
			
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
			String sql = "delete from user";
			pstmt = connection.prepareStatement(sql);

			//4. SQL문 실행		
			int rows = pstmt.executeUpdate();
			sql = "alter table user auto_increment = 1";
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
		return "--------------------User----------------------";
	}
}
