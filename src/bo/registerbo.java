package bo;

import java.math.BigInteger;
import java.security.MessageDigest;

import dao.registerdao;

public class registerbo {
	registerdao khdao = new registerdao();

	public int checkKhachHang(String tk) {
		return khdao.checkKhachHang(tk);
	}
	public void addKhachHang(String hoTen, String diaChi, String sdt, String email, String tk, String mk) {
		khdao.addKhachHang(hoTen, diaChi, sdt, email, tk, mk);
	}
	public static String ecrypt(String text){
		try {
			String enrtext;
			MessageDigest msd = MessageDigest.getInstance("MD5");
			byte[] srctextbyte = text.getBytes("UTF-8");
			byte[] enrtextbyte = msd.digest(srctextbyte);
			BigInteger big = new BigInteger(1, enrtextbyte);
			enrtext = big.toString(16);
			return enrtext;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return text;
	}
}
