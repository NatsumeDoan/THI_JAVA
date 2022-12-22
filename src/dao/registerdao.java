package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class registerdao {
	public int checkKhachHang(String tdn) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from KHACHHANG where tendn = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tdn);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				return rs.getInt(1);
			}
			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int addKhachHang(String ht, String dc, String sdt, String email, String tdn, String mk) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into KhachHang values (?, ?, ?, ?, ?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ht);
			cmd.setString(2, dc);
			cmd.setString(3, sdt);
			cmd.setString(4, email);
			cmd.setString(5, tdn);
			cmd.setString(6, mk);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
