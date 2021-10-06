package bookmall.vo;

public class memberVO {
	private int no;
	private String name;
	private String email;
	private String phone_number;
	private String password;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "memberVO [no=" + no + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number
				+ ", password=" + password + "]";
	}
	
	
	
}
