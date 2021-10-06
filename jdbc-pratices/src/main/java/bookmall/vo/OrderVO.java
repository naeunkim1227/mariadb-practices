package bookmall.vo;

public class OrderVO {
	private int no;
	private int order_no;
	private int order_money;
	private String address;
	private int member_no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getOrder_money() {
		return order_money;
	}
	public void setOrder_money(int order_money) {
		this.order_money = order_money;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
	@Override
	public String toString() {
		return "OrderVO [no=" + no + ", order_no=" + order_no + ", order_money=" + order_money + ", address=" + address
				+ ", member_no=" + member_no + "]";
	}

}
