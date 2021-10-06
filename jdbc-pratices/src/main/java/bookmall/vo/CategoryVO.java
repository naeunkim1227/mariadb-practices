package bookmall.vo;

public class CategoryVO {
	private int no;
	private String category;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "CategoryVO [no=" + no + ", category=" + category + "]";
	}
	
	
}
