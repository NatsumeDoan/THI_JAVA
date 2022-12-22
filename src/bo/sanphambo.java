package bo;

import java.util.ArrayList;

import bean.sanphambean;
import dao.sanphamdao;

public class sanphambo {
	sanphamdao spdao = new sanphamdao();
	ArrayList<sanphambean> ds;

	public ArrayList<sanphambean> getsp() {
		ds = spdao.getsp();
		return ds;
	}

	public ArrayList<sanphambean> sploai(String maloai) {
		ds = spdao.sploai(maloai);
		return ds;
	}

	public sanphambean sp(String masp) {
		sanphambean spbean = new sanphambean();
		spbean = spdao.sp(masp);
		return spbean;
	}
	public int kiemtra(String masp) {
		return spdao.kiemtra(masp);
	}
	public ArrayList<sanphambean> timkiem(String timkiem) {
		ds = spdao.timkiem(timkiem);
		return ds;
	}

	public void addsp(String msp, String tsp, String anhsp, String mota, String ml, long g) {
		spdao.addsp(msp, tsp, anhsp, mota, ml, g);
	}

	public void deletesp(String ms) {
		spdao.deletesp(ms);
	}

	public String getAnh(String xoa) {
		String[] arr = spdao.getAnh(xoa).split("\\/");
		return arr[arr.length - 1];
	}
	public String getAnhsp(String masp) {
		return spdao.getAnh(masp);
	}
	public String getTensp(String masp) {
		return spdao.getTensp(masp);
	}

	public void suasp(String mspc, String msp, String tsp, String anhsp, String mota, String ml, Long g) {
		spdao.suasp(mspc, msp, tsp, anhsp, mota, ml, g);
	}
	public void suaspcungma(String mspc, String tsp, String anhsp, String mota, String ml, Long g) {
		spdao.suaspcungma(mspc, tsp, anhsp, mota, ml, g);
	}
	public int getkiemtra(String masp) {
		return spdao.getkiemtra(masp);
	}
}
