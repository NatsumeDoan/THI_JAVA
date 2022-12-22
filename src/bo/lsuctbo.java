package bo;

import java.util.ArrayList;

import bean.lsuctbean;
import dao.lsuctdao;

public class lsuctbo {
	lsuctdao lsudao = new lsuctdao();
	public ArrayList<lsuctbean> getlsuct(String mahd) {
		return lsudao.getlsuct(mahd);
	}
}
