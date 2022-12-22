package bo;

import java.util.ArrayList;

import bean.giohangbean;
import dao.giohangdao;

public class giohangbo {
	giohangdao ghdao = new giohangdao();
	ArrayList<giohangbean> dsgh;

	public ArrayList<giohangbean> getgh(String mkh) {
		dsgh = ghdao.getgh(mkh);
		return dsgh;
	}
	public void Them(String mkh,String masp, long soluong, long gia, String size) {
		long tam=soluong;
		if(ghdao.kiemtra( mkh, masp,size)==1) {
			soluong= soluong+ghdao.getsl( mkh, masp,size);
		}
		if(tam!=soluong) {
			ghdao.themsl(mkh,masp,soluong,size);
		}
		else
			ghdao.them(mkh,masp,soluong,gia,size);
	}
	public void sua(String mkh,String masp, long soluong, long gia, String size,String magh) {
		long tam=soluong;
		if(ghdao.kiemtrasua( mkh, masp,size,magh)==1) {
			soluong= soluong+ghdao.getslsua( mkh, masp,size,magh);
		}
		if(tam!=soluong) {
			ghdao.themsl(mkh,masp,soluong,size);
		}
		else
			ghdao.them(mkh,masp,soluong,gia,size);
			ghdao.xoa(mkh, magh);
	}
	public void Tratatca(String mkh) {
		ghdao.Tratatca(mkh);
	}
	public void xoa(String mkh,String mgh) {
		ghdao.xoa(mkh,mgh);
	}
}
