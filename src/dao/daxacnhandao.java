package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.daxacnhanbean;

public class daxacnhandao {
	public ArrayList<daxacnhanbean> getdanhsachdaxacnhan() {
		try {
			// B1: Ket noi vao csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			// B2: Lay du lieu ve
			ArrayList<daxacnhanbean> ds = new ArrayList<daxacnhanbean>();
			String sql = "select * from vchitiet";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyet qua tap du lieu lay ve
			while (rs.next()) {

				String MaHoaDon = rs.getString("MaHD");
				String tensp = rs.getString("TenSP");
				String anhsp = rs.getString("AnhSP");
				Long soluong =Long.parseLong(rs.getString("SoLuong"));
				String size = rs.getString("Size");
				Long gia =Long.parseLong(rs.getString("Gia"));
				ds.add(new daxacnhanbean(MaHoaDon, tensp, anhsp, soluong, size, gia));
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
}
