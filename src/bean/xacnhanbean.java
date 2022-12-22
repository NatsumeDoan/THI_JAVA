package bean;

import java.util.Date;

public class xacnhanbean {
	private String mahd;
	private String makh;
	private String hoten;
	private String Diachi;
	private String sdt;
	private Date ngaymua;
	private boolean trangthai;

	public xacnhanbean(String mahd, String makh,String hoten, String diachi, String sdt, Date ngaymua, boolean trangthai) {
		super();
		this.mahd= mahd;
		this.makh= makh;
		this.hoten = hoten;
		Diachi = diachi;
		this.sdt = sdt;
		this.ngaymua = ngaymua;
		this.trangthai = trangthai;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public xacnhanbean() {
		super();
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

}
