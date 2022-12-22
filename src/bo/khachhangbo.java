package bo;

import java.math.BigInteger;
import java.security.MessageDigest;

import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();

	public int getTaiKhoan(String tentk, String pass){
		return khdao.getTaiKhoan(tentk, pass);
	}
	public String getmakh(String tdn){
		return khdao.getmakh(tdn);
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
