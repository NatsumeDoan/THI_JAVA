package bean;

public class daxacnhanbean {
	private String mahd;
	private String tensp;
	private String anhsp;
	private long soluong;
	private String size;
	private long gia;

	public daxacnhanbean(String mahd, String tensp, String anhsp, long soluong, String size, long gia) {
		super();
		this.mahd = mahd;
		this.tensp = tensp;
		this.anhsp = anhsp;
		this.soluong = soluong;
		this.size = size;
		this.gia = gia;
	}

	public daxacnhanbean() {
		super();
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getAnhsp() {
		return anhsp;
	}

	public void setAnhsp(String anhsp) {
		this.anhsp = anhsp;
	}

	public long getSoluong() {
		return soluong;
	}

	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

}
