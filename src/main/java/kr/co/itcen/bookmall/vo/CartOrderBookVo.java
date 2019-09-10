package kr.co.itcen.bookmall.vo;

import java.util.Date;

public class CartOrderBookVo extends Vo{
	int no;
	int quantity;
	String orderDate;
	int bookNo;
	int userNo;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "CartOrderBookVo [no=" + no + ", quantity=" + quantity + ", orderDate=" + orderDate + ", bookNo="
				+ bookNo + ", userNo=" + userNo + "]";
	}
	
	
}
