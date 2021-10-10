package bookmall.vo;

public class OrderbookVO {
	private int no;
	private int order_no;
	private int book_no;
	private int order_book_count;
	private int order_book_price;
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
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getOrder_book_count() {
		return order_book_count;
	}
	public void setOrder_book_count(int order_book_count) {
		this.order_book_count = order_book_count;
	}
	public int getOrder_book_price() {
		return order_book_price;
	}
	public void setOrder_book_price(int order_book_price) {
		this.order_book_price = order_book_price;
	}
	
	
	@Override
	public String toString() {
		return 
		"주문번호 : " + order_no + " / 책 번호 : " + book_no + " / 주문 수량 : " + order_book_count + "/ 가격 :  " +  order_book_price;
	
	}
	
	
}
