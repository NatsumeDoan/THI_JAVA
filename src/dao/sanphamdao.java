package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sanphambean;

public class sanphamdao {
	public ArrayList<sanphambean> getsp() {
		try {
			ArrayList<sanphambean> dssp = new ArrayList<sanphambean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from SANPHAM";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String masp = rs.getString("MaSP");
				String tensp = rs.getString("TenSP");
				String anh = rs.getString("AnhSP");
				String mota = rs.getNString("MoTa");
				String maloai = rs.getString("Maloai");
				long gia = rs.getLong("Gia");
				dssp.add(new sanphambean(masp, tensp, anh, mota, maloai, gia));
			}
			return dssp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<sanphambean> sploai(String ml) {
		try {
			ArrayList<sanphambean> dssp = new ArrayList<sanphambean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from SANPHAM where MaLoai=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String masp = rs.getString("MaSP");
				String tensp = rs.getString("TenSP");
				String anh = rs.getString("AnhSP");
				String mota = rs.getNString("MoTa");
				String maloai = rs.getString("Maloai");
				long gia = rs.getLong("Gia");
				dssp.add(new sanphambean(masp, tensp, anh, mota, maloai, gia));
			}
			return dssp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public sanphambean sp(String masp) {
		try {
			sanphambean spbean = new sanphambean();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from SANPHAM where MaSP=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masp);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String msp = rs.getString("MaSP");
				String tensp = rs.getString("TenSP");
				String anh = rs.getString("AnhSP");
				String mota = rs.getString("MoTa");
				String maloai = rs.getString("Maloai");
				long gia = rs.getLong("Gia");
				spbean = new sanphambean(msp, tensp, anh, mota, maloai, gia);
				return spbean;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<sanphambean> timkiem(String timkiem) {
		try {
			ArrayList<sanphambean> dssp = new ArrayList<sanphambean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select * from SANPHAM where TenSP like CONCAT('%', ? , '%')";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, timkiem);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String masp = rs.getString("MaSP");
				String tensp = rs.getString("TenSP");
				String anh = rs.getString("AnhSP");
				String mota = rs.getNString("MoTa");
				String maloai = rs.getString("Maloai");
				long gia = rs.getLong("Gia");
				dssp.add(new sanphambean(masp, tensp, anh, mota, maloai, gia));
			}
			return dssp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int kiemtra(String timkiem) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select count(*) from SANPHAM where TenSP like CONCAT('%', ? , '%')";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, timkiem);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int addsp(String msp, String tsp, String anhsp, String mota, String ml, Long g) {
		try {

			String nameimg = "img-sp/" + anhsp;
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into SANPHAM values (?, ?, ?, ?, ?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, msp);
			cmd.setString(2, tsp);
			cmd.setString(3, nameimg);
			cmd.setNString(4, mota);
			cmd.setString(5, ml);
			cmd.setLong(6, g);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String getAnh(String masp) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select AnhSP from SANPHAM where MaSP =?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masp);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getTensp(String masp) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select TenSP from SANPHAM where MaSP =?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masp);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int deletesp(String masp) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from SANPHAM where MaSP = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masp);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int suasp(String mspc, String msp, String tsp, String anhsp, String mota, String ml,Long g) {
		try {

			String nameimg = "img-sp/" + anhsp;
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update SANPHAM\r\n"
					+ "set MaSP=?,TenSP=?,AnhSP=?,MoTa=?,MaLoai=?,Gia=?\r\n"
					+ "Where MaSP=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, msp);
			cmd.setString(2, tsp);
			cmd.setString(3, nameimg);
			cmd.setNString(4, mota);
			cmd.setString(5, ml);
			cmd.setLong(6, g);
			cmd.setString(7, mspc);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int suaspcungma(String mspc, String tsp, String anhsp, String mota, String ml,Long g) {
		try {

			String nameimg = "img-sp/" + anhsp;
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update SANPHAM\r\n"
					+ "set TenSP=?,AnhSP=?,MoTa=?,MaLoai=?,Gia=?\r\n"
					+ "Where MaSP=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tsp);
			cmd.setString(2, nameimg);
			cmd.setNString(3, mota);
			cmd.setString(4, ml);
			cmd.setLong(5, g);
			cmd.setString(6, mspc);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int getkiemtra(String masp) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from SANPHAM where MaSP = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masp);
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
}