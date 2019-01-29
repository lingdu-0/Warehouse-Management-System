package cn.wb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wb.dao.impl.BaseDao;
import cn.wb.entity.Material;
import cn.wb.dao.MaterialDao;

public class MaterialDaoImpl extends BaseDao implements MaterialDao {

	@Override
	// 查看全部物料
	public List<Material> listAllMaterial() {
		List<Material> list = new ArrayList<Material>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM material ORDER BY mid ASC";
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();// 读取数据库数据
			while (rs.next()) {
				Material material = new Material(rs.getInt("mid"), rs.getString("material_id"),
						rs.getString("material_name"), rs.getString("c_name"), rs.getString("information"),
						rs.getInt("number"), rs.getString("price"));
				list.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<Material> getMaterialCheck(String material_name) {
		List<Material> list = new ArrayList<Material>();
		Material material = null;// 物料对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM material WHERE material_name = ?";		
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, material_name);
			rs = ps.executeQuery();// 读取数据库数据
			while(rs.next()) {				
				material = new Material(rs.getInt("mid"), rs.getString("material_id"), rs.getString("material_name"),
						rs.getString("c_name"), rs.getString("information"), rs.getInt("number"),
						rs.getString("price"));
				list.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	// 根据物料名称加载物料信息
	public Material getMaterialByName(String material_name) {
		Material material = null;// 物料对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM material WHERE material_name=?";
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, material_name);
			rs = ps.executeQuery();// 读取数据库数据
			System.out.println(rs.getString(2));
			if (rs.next()) {
				System.out.println("sql");
				material = new Material(rs.getString("material_id"), rs.getString("material_name"),
						rs.getString("c_name"), rs.getString("information"), rs.getInt("number"),
						rs.getString("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return material;
	}

	@Override
	// 添加物料
	public int addMaterial(Material material) {
		String sql = "INSERT INTO material (mid,material_id,material_name,c_name,information,number,price) VALUES (DEFAULT,?,?,?,?,?,?)";
		Object[] args = { material.getMaterial_id(), material.getMaterial_name(), material.getC_name(),
				material.getInformation(), material.getNumber(), material.getPrice()};
		return this.execute(sql, args);
	}

	@Override
	// 删除物料
	public int deleteMaterial(int mid) {
		String sql = "DELETE FROM material WHERE mid=?";
		Object[] args = { mid };
		return this.execute(sql, args);
	}

	@Override
	// 修改物料
	public int updateMaterial(Material material) {
		String sql = "UPDATE material SET material_id=?,material_name=?,c_name=?,information=?,number=?,price=?WHERE mid=?";
		Object[] args = {material.getMaterial_id(), material.getMaterial_name(), material.getC_name(),
				material.getInformation(), material.getNumber(), material.getPrice(), material.getMid()};
		return this.execute(sql, args);
	}

	@Override
	public int countMaterialBymid(int mid) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT COUNT(1) FROM material WHERE mid=?";
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			rs = ps.executeQuery();// 读取数据库数据
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			result = -1;
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public Material getMaterialByID(int mid) {
		Material material = null;// 物料对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM material WHERE mid=?";
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			rs = ps.executeQuery();// 读取数据库数据
			if (rs.next()) {
				material = new Material(rs.getInt("mid"), rs.getString("material_id"), rs.getString("material_name"),
						rs.getString("c_name"), rs.getString("information"), rs.getInt("number"),
						rs.getString("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return material;
	}
}
