package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.xacnhanbean;

public class xacnhandao {
	public ArrayList<xacnhanbean> getdanhsach() {
		try {
			// B1: Ket noi vao csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			// B2: Lay du lieu ve
			ArrayList<xacnhanbean> ds = new ArrayList<xacnhanbean>();
			String sql = "select * from vxacnhan where TrangThai = '0'";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyet qua tap du lieu lay ve
			while (rs.next()) {
				String MaHoaDon = rs.getString("MaHD");
				String makh = rs.getString("MaKH");
				String hoten = rs.getString("HoTen");
				String diachi = rs.getString("DiaChi");
				String sdt = rs.getString("Sdt");
				Date ngayMua = rs.getDate("NgayMua");
				boolean trangthai = rs.getBoolean("TrangThai");
				ds.add(new xacnhanbean(MaHoaDon, makh, hoten, diachi, sdt, ngayMua, trangthai));
			}
			// b4: Dong rs va cn
			rs.close();
			cs.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<xacnhanbean> getdanhsachdaxacnhan() {
		try {
			// B1: Ket noi vao csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			// B2: Lay du lieu ve
			ArrayList<xacnhanbean> ds = new ArrayList<xacnhanbean>();
			String sql = "select * from vxacnhan where TrangThai = '1'";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyet qua tap du lieu lay ve
			while (rs.next()) {
				String MaHoaDon = rs.getString("MaHD");
				String makh = rs.getString("MaKH");
				String hoten = rs.getString("HoTen");
				String diachi = rs.getString("DiaChi");
				String sdt = rs.getString("Sdt");
				Date ngayMua = rs.getDate("NgayMua");
				boolean trangthai = rs.getBoolean("TrangThai");
				ds.add(new xacnhanbean(MaHoaDon, makh, hoten, diachi, sdt, ngayMua, trangthai));
			}
			// b4: Dong rs va cn
			rs.close();
			cs.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int xacnhan(String MaHoaDon) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "UPDATE HOADON SET TrangThai=1 WHERE  MaHD= ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, MaHoaDon);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
