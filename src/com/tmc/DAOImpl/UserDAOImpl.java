package com.tmc.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tmc.Utils.DBUtil;
import com.tmc.DAO.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public void userAdd(String userName, String passWord, String mobileNo) {

		String sql = "insert into auth_user values (?,?,?,?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ps.setString(3, mobileNo);
			ps.setString(4, "1");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps);
		}
	}

	@Override
	public int userLogin(String userName, String passWord) {

		String sql = "select * from auth_user where username = ? and password = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet res = null;
		int state = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			res = ps.executeQuery();
			if (res.next()) {
				state = res.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, res);
		}
		return state;

	}

}
