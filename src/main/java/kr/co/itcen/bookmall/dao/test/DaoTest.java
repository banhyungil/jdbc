package kr.co.itcen.bookmall.dao.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartOrderBookDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.Dao;
import kr.co.itcen.bookmall.dao.MyOrderDao;
import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CartOrderBookVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.MyOrderVo;
import kr.co.itcen.bookmall.vo.OrderBookVo;
import kr.co.itcen.bookmall.vo.UserVo;
import kr.co.itcen.bookmall.vo.Vo;

public class DaoTest {

	static List<Vo> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deleteAll();											//delete시 auto_increment 1로 초기화 시킨다.
		
		//insert
		insertTest(new CategoryDao(), createCategoryVo());
		insertTest(new BookDao(), createBookVo());
		insertTest(new UserDao(), createUserVo());
		insertTest(new MyOrderDao(), createMyOrderVo());
		insertTest(new OrderBookDao(), createOrderBookVo());
		insertTest(new CartOrderBookDao(), createCartOrderBookVo());
		
		//select
		selectTest(new CategoryDao());
		selectTest(new BookDao());
		selectTest(new UserDao());
		selectTest(new MyOrderDao());
		selectTest(new OrderBookDao());
		selectTest(new CartOrderBookDao());
	}
	
	public static void deleteAll() {
		new OrderBookDao().delete();
		new CartOrderBookDao().delete();
		new MyOrderDao().delete();
		new BookDao().delete();
		new CategoryDao().delete();
		new UserDao().delete();		
	}
	
	public static void insertTest(Dao dao, List<Vo> list) {

		for(Vo vo : list) {
			dao.insert(vo);
		}
	}

	public static void selectTest(Dao dao) {
		list = dao.getList();
		
		System.out.println(dao.toString());
		
		for(Vo vo : list) {
			System.out.println(vo.toString());
		}
		
		System.out.println("");
	}


	//-----------------------createVo----------------------------------
	public static List<Vo> createBookVo() {
		List<Vo> list = new ArrayList<Vo>();
		BookVo bvo1 = new BookVo();

		String title = "a-book";
		int price = 1000;
		int categoryNo = 1;
		bvo1.setCategoryNo(categoryNo);
		bvo1.setPrice(price);
		bvo1.setTitle(title);

		list.add(bvo1);

		BookVo bvo2 = new BookVo();
		title = "b-book";
		price = 2000;
		categoryNo = 1;
		bvo2.setCategoryNo(categoryNo);
		bvo2.setPrice(price);
		bvo2.setTitle(title);

		list.add(bvo2);

		BookVo bvo3 = new BookVo();
		title = "c-book";
		price = 3000;
		categoryNo = 1;
		bvo3.setCategoryNo(categoryNo);
		bvo3.setPrice(price);
		bvo3.setTitle(title);

		list.add(bvo3);

		return list;
	}

	public static List<Vo> createCategoryVo() {
		List<Vo> list = new ArrayList<Vo>();
		CategoryVo cvo1 = new CategoryVo();

		String name = "category1";
		cvo1.setName(name);
		list.add(cvo1);

		CategoryVo cvo2 = new CategoryVo();

		name = "category2";
		cvo2.setName(name);
		list.add(cvo2);

		CategoryVo cvo3 = new CategoryVo();
		name = "category3";
		cvo3.setName(name);

		list.add(cvo3);

		return list;
	}

	public static List<Vo> createCartOrderBookVo() {
		List<Vo> list = new ArrayList<Vo>();
		CartOrderBookVo cob1 = new CartOrderBookVo();

		int quantity = 10;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		String orderDate = format.format(Calendar.getInstance().getTime());
		int bookNo = 1;
		int userNo = 1;

		cob1.setBookNo(bookNo);
		cob1.setOrderDate(orderDate);
		cob1.setQuantity(quantity);
		cob1.setUserNo(userNo);

		list.add(cob1);

		CartOrderBookVo cob2 = new CartOrderBookVo();

		quantity = 5;	
		orderDate = format.format(Calendar.getInstance().getTime());
		bookNo = 2;
		userNo = 2;

		cob2.setBookNo(bookNo);
		cob2.setOrderDate(orderDate);
		cob2.setQuantity(quantity);
		cob2.setUserNo(userNo);
		list.add(cob2);

		return list;
	}

	public static List<Vo> createUserVo() {
		List<Vo> list = new ArrayList<Vo>();
		UserVo uvo1 = new UserVo();

		String id ="user1";
		String password = "user1";
		String name = "user1Name";
		String phoneNum = "user1PhoneNum";
		String email = "user1Email";
		String address = "user1Address";

		uvo1.setName(name);
		uvo1.setAddress(address);
		uvo1.setEmail(email);
		uvo1.setId(id);
		uvo1.setPassword(password);
		uvo1.setPhoneNum(phoneNum);

		list.add(uvo1);

		UserVo uvo2 = new UserVo();

		id ="user2";
		password = "user2";
		name = "user2Name";
		phoneNum = "user2PhoneNum";
		email = "user2Email";
		address = "user2Address";

		uvo2.setName(name);
		uvo2.setAddress(address);
		uvo2.setEmail(email);
		uvo2.setId(id);
		uvo2.setPassword(password);
		uvo2.setPhoneNum(phoneNum);
		list.add(uvo2);

		return list;
	}

	public static List<Vo> createMyOrderVo() {
		List<Vo> list = new ArrayList<Vo>();
		MyOrderVo movo1 = new MyOrderVo();

		int payment = 1000;
		String shipTo = "Deagu";
		String payComplete = "Y";
		String shipComplete = "N";
		int userNo = 1;

		movo1.setPayment(payment);
		movo1.setShipTo(shipTo);
		movo1.setPayComplete(payComplete);
		movo1.setShipComplete(shipComplete);
		movo1.setUserNo(userNo);

		list.add(movo1);

		return list;
	}

	public static List<Vo> createOrderBookVo() {
		List<Vo> list = new ArrayList<Vo>();
		OrderBookVo obvo1 = new OrderBookVo();

		int quantity = 10;
		int bookNo = 1;
		int orderNo = 1;

		obvo1.setQuantity(quantity);
		obvo1.setBookNo(bookNo);
		obvo1.setOrderNo(orderNo);

		list.add(obvo1);

		OrderBookVo obvo2 = new OrderBookVo();

		quantity = 5;
		bookNo = 2;
		orderNo = 1;

		obvo2.setQuantity(quantity);
		obvo2.setBookNo(bookNo);
		obvo2.setOrderNo(orderNo);

		list.add(obvo2);
		return list;
	}

}
