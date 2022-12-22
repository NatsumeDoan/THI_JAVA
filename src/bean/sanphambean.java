package bean;

public class sanphambean {
	private String masp;
	private String tensp;
	private String anhsp;
	private String mota;
	private String maloai;
	private long gia;
	public sanphambean(String masp, String tensp, String anhsp, String mota, String maloai, long gia) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.anhsp = anhsp;
		this.mota = mota;
		this.maloai = maloai;
		this.gia = gia;
	}
	public sanphambean() {
		super();
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
	public String getAnhsp() {
		return anhsp;
	}
	public void setAnhsp(String anhsp) {
		this.anhsp = anhsp;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	
	
}
