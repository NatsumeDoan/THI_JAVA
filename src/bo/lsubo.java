package bo;

import java.sql.Date;
import java.util.ArrayList;

import bean.lichsubean;
import dao.lichsudao;

public class lsubo {
	lichsudao lsudao = new lichsudao();
	ArrayList<lichsubean> list ;
	public void themhd(String makh, Date ngaymua,String diachi) {
		lsudao.themhd(makh, ngaymua, diachi);
	}
	public ArrayList<lichsubean> getlistlsu(String makh){
		list = lsudao.getlistlsu(makh);
		return list;
	}
	public ArrayList<Integer> getmahoadon(String makh){
		ArrayList<Integer> ma ;
		ma = lsudao.getmahoadon(makh);
		return ma;
	}
	public void themchitiet(String ms, Long sl, int i,String size) {
		lsudao.themchitiet(ms, sl, i, size);
	}
}
