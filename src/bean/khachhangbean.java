package bean;

public class khachhangbean {
	private String tendn;
	private String pass;
	public khachhangbean(String tendn, String pass) {
		super();
		this.tendn = tendn;
		this.pass = pass;
	}
	public khachhangbean() {
		super();
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
