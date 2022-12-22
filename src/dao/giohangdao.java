package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.giohangbean;

public class giohangdao {
	public ArrayList<giohangbean> getgh(String mkh) {
		try {
			ArrayList<giohangbean> dsgh = new ArrayList<giohangbean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from vgio where MaKH=? ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mkh);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String masp = rs.getString("MaSP");
				String magh = rs.getString("MaGH");
				String makh = rs.getString("MaKH");
				long gia = rs.getLong("Gia");
				long soluong = rs.getLong("SoLuong");
				String size = rs.getString("Size");
				String tensp = rs.getString("TenSP");
				dsgh.add(new giohangbean(magh, makh, masp, gia, soluong, size, tensp));
			}
			return dsgh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int them(String mkh, String masp, long soluong, long gia, String size) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into GIOHANG values (?, ?, ?,?,?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			int Makh = Integer.parseInt(mkh);
			cmd.setInt(1, Makh);
			cmd.setString(2, masp);
			cmd.setLong(3, gia);
			cmd.setLong(4, soluong);
			cmd.setString(5, size);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int kiemtra(String mkh, String masp, String size) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select COUNT(*) from GIOHANG where MaKH= ? and MaSP= ? and Size = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mkh);
			cmd.setString(2, masp);
			cmd.setString(3, size);
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

	public int kiemtrasua(String mkh, String masp, String size, String MaGH) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select COUNT(*) from GIOHANG where MaKH= ? and MaSP= ? and Size = ? and MaGH != ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mkh);
			cmd.setString(2, masp);
			cmd.setString(3, size);
			cmd.setString(4, MaGH);
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

	public int getsl(String mkh, String masp, String size) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select SoLuong from GIOHANG where MaKH= ? and MaSP= ? and Size = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mkh);
			cmd.setString(2, masp);
			cmd.setString(3, size);
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

	public int getslsua(String mkh, String masp, String size, String magh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select SoLuong from GIOHANG where MaKH= ? and MaSP= ? and Size = ? and MaGH != ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mkh);
			cmd.setString(2, masp);
			cmd.setString(3, size);
			cmd.setString(4, magh);
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

	public int themsl(String mkh, String masp, long soluong, String size) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update GIOHANG\r\n" + "set SoLuong = ?\r\n" + "where MaSP= ? and size= ? and MaKH=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, soluong);
			cmd.setString(2, masp);
			cmd.setString(3, size);
			cmd.setString(4, mkh);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int Tratatca(String mkh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from GIOHANG where MaKH= ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mkh);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int xoa(String mkh, String mgh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from GIOHANG where MaKH= ? and MaGH=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mkh);
			cmd.setString(2, mgh);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
