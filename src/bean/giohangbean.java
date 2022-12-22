package bean;

public class giohangbean {
	private String magh;
	private String makh;
	private String masp;
	private Long gia;
	private Long soluong;
	private String size;
	private String tensp;
	public giohangbean(String magh, String makh, String masp, Long gia, Long soluong, String size, String tensp) {
		super();
		this.magh = magh;
		this.makh = makh;
		this.masp = masp;
		this.gia = gia;
		this.soluong = soluong;
		this.size = size;
		this.tensp = tensp;
	}
	public giohangbean() {
		super();
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getMagh() {
		return magh;
	}
	public void setMagh(String magh) {
		this.magh = magh;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
