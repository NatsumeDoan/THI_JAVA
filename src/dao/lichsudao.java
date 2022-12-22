package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsubean;

public class lichsudao {
	String sql;

	public ArrayList<lichsubean> getlistlsu(String makh) {
		ArrayList<lichsubean> list = new ArrayList<lichsubean>();
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			sql = "select * from HOADON where MaKH =? ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				list.add(new lichsubean(rs.getString(1), rs.getString(2), rs.getString(5), rs.getTimestamp(3),
						rs.getBoolean(4)));
			}
			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int themchitiet(String ms, Long sl, int i,String size) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into CHITIETHOADON values (?, ?, ?,?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, i);
			cmd.setLong(2, sl);
			cmd.setString(3, size);
			cmd.setString(4, ms);
			
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int themhd(String makh, Date ngaymua,String diachi) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into HOADON values (?, ?, ?,?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			cmd.setDate(2, ngaymua);
			cmd.setBoolean(3, false);
			cmd.setString(4, diachi);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ArrayList<Integer> getmahoadon(String makh) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select MaHD from HOADON where MaKH = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
