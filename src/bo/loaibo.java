package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getloai() {
		ds = ldao.getloai();
		return ds;
	}
	public void deletel(String maloai) {
		ldao.deletel(maloai);
	}
	public void addl(String maloai, String tenloai,String anhloai) {
		ldao.addl(maloai, tenloai, anhloai);
	}
	public int kiemtraloai(String maloai) {
		return ldao.kiemtrama(maloai);
	}
	public String getAnh(String ml) {
		String[] arr = ldao.getAnh(ml).split("\\/");
		return arr[arr.length - 1];
	}
	public void sual(String mlc, String ml, String tl, String anhl) {
		ldao.sual(mlc,ml,tl,anhl);
	}
}
