package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() {
		try {
			ArrayList<loaibean> dsloai = new ArrayList<loaibean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from LOAI";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String maloai = rs.getString("MaLoai");
				String tenloai = rs.getString("TenLoai");
				String anhloai = rs.getString("AnhLoai");
				dsloai.add(new loaibean(maloai, tenloai, anhloai));
			}

			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
			return dsloai;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public int deletel(String maloai) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from LOAI where MaLoai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int kiemtrama(String ml) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from LOAI where MaLoai= ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			cs.cn.close();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String getAnh(String ml) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select AnhLoai from LOAI where MaLoai =?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addl(String ml, String tl, String anhsp) {
		try {

			String nameimg = "img-loai/" + anhsp;
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into LOAI values (?, ?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			cmd.setNString(2, tl);
			cmd.setString(3, nameimg);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int sual(String mlc, String ml, String tl, String anhl) {
		try {

			String nameimg = "img-loai/" + anhl;
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update LOAI\r\n" + "set MaLoai=?,TenLoai=?,AnhLoai=?\r\n" + "Where MaLoai=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			cmd.setString(2, tl);
			cmd.setString(3, nameimg);
			cmd.setString(4, mlc);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
