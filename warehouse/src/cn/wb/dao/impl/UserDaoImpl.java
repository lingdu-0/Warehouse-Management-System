package cn.wb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.wb.dao.UserDao;
import cn.wb.entity.User;
public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public List<User> listUser() {
		String sql = "SELECT * FROM users";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		User user=null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("upwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(rs, ps, conn);
		}		
		return list;
	}
	
	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO users(uname,upwd) VALUES(?,?)";
		Object[] args={user.getUname(),user.getUpwd()};		
		return this.execute(sql, args);
	}
	
	@Override
	public int deleteUser(int uid) {
		String sql = "DELETE FROM users WHERE uid=?";
		Object[] args={uid};		
		return this.execute(sql, args);
	}
	
	@Override
	public int modifyUser(User user) {
		String sql = "UPDATE users SET uname=?,upwd=? WHERE uid=?";
		Object[] args={user.getUname(),user.getUpwd(),user.getUid()};		
		return this.execute(sql, args);
	}
	
	@Override
	public User getUser(User user) {
		String sql = "SELECT * FROM users WHERE uname=? AND upwd=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User newUser=null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			rs = ps.executeQuery();
			if(rs.next()) {
				newUser = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(rs, ps, conn);
		}		
		return newUser;
	}
}
