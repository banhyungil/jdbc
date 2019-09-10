package kr.co.itcen.bookmall.vo;

public class MyOrderVo extends Vo{
	
	int no;
	int payment;
	String shipTo;
	String payComplete;
	String shipComplete;
	int userNo;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getShipTo() {
		return shipTo;
	}
	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}
	public String getPayComplete() {
		return payComplete;
	}
	public void setPayComplete(String payComplete) {
		this.payComplete = payComplete;
	}
	public String getShipComplete() {
		return shipComplete;
	}
	public void setShipComplete(String shipComplete) {
		this.shipComplete = shipComplete;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", payment=" + payment + ", shipTo=" + shipTo + ", payComplete=" + payComplete
				+ ", shipComplete=" + shipComplete + ", userNo=" + userNo + "]";
	}
	
}
