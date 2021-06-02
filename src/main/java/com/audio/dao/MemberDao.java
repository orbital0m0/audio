package com.audio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.audio.dto.MemberDto;
import com.audio.util.DBconnection;


public class MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	String query; 

	public int bringMemeber(String id, String pwd) throws NamingException, SQLException {

		DBconnection db = new DBconnection();

		conn = db.getCon();
		query = "select * from member where id = ? and pwd=?";
		pstmt = conn.prepareStatement(query);

		pstmt.setString(1, id);
		pstmt.setString(2, pwd);

		rs = pstmt.executeQuery();
		if(rs.next()) {
			MemberDto member = new MemberDto();
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			System.out.println("bringMember: " +member);
			return 1;
		}


		return 0;
	}

}
