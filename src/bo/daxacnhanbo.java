package bo;

import java.util.ArrayList;

import bean.daxacnhanbean;
import dao.daxacnhandao;

public class daxacnhanbo {
	daxacnhandao dxndao = new daxacnhandao();
	public ArrayList<daxacnhanbean> getdanhsachdathanhtoan() {
		return dxndao.getdanhsachdaxacnhan();
	}
}
