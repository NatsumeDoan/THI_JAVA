package bean;

public class lsuctbean {
	private String mahd;
	private String masp;
	private String tensp;
	private int soluong;
	private int gia;
	private String anh;
	private String Size;
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public lsuctbean(String mahd, String masp, String tensp, int soluong, int gia, String anh, String size) {
		super();
		this.mahd = mahd;
		this.masp = masp;
		this.tensp = tensp;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		Size = size;
	}
	public lsuctbean() {
		super();
	}
	
	
}
