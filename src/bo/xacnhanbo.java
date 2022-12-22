package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.xacnhandao;

public class xacnhanbo {
	xacnhandao xndao = new xacnhandao();
	public ArrayList<xacnhanbean> getdanhsach() {
		return xndao.getdanhsach();
	}
	public int xacnhan(String MaHoaDon) {
		return xndao.xacnhan(MaHoaDon);
	}
	public ArrayList<xacnhanbean> getdanhsachdaxacnhan() {
		return xndao.getdanhsachdaxacnhan();
	}
}
