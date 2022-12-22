package bean;

import java.util.Date;

public class lichsubean {
	private String mahd;
	private String makh;
	private String diachi;
	private Date ngaymua;
	private boolean trangthai;
	
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}


	public lichsubean() {
		super();
	}

	public lichsubean(String mahd, String makh, String diachi, Date ngaymua, boolean trangthai) {
		super();
		this.mahd = mahd;
		this.makh = makh;
		this.diachi = diachi;
		this.ngaymua = ngaymua;
		this.trangthai = trangthai;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
}
