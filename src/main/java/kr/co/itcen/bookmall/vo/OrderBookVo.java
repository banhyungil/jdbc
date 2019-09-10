package kr.co.itcen.bookmall.vo;

public class OrderBookVo extends Vo{
	
	int no;
	int quantity;
	int bookNo;
	int orderNo;
	
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
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", quantity=" + quantity + ", bookNo=" + bookNo + ", orderNo=" + orderNo + "]";
	}


	
}
