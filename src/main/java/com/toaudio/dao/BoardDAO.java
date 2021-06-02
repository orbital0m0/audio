package com.toaudio.dao;

import java.sql.*;
import java.util.ArrayList;

import com.audio.util.DBconnection;
import com.toaudio.dto.BoardDTO;

public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int getCountAll() {
		int result = 0;
		String sql = "select count(*) from audio_file";
		try {
			conn = DBconnection.getCon();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<BoardDTO> getList(int start, int end){
		String sql = "select * from (select row_number() over(order by codenum desc)Rnum, A.* from(select* from audio_file)A)R where Rnum >= ? and Rnum <= ?";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			conn = DBconnection.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setCodenum(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setM_id(rs.getString(4));
				board.setRealpath(rs.getString(5));
				board.setUpdate_time(rs.getString(6));
				list.add(board);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public BoardDTO getAudio(int no) {
		String sql = "select * from audio_file where codenum = ?";
		try {
			conn = DBconnection.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setCodenum(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setM_id(rs.getString(3));
				board.setRealpath(rs.getString(4));
				board.setUpdate_time(rs.getString(5));
				return board;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
