package com.toaudio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toaudio.dao.BoardDAO;
import com.toaudio.dto.BoardDTO;

public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}
	
	public void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int pageSize = 10; //화면에 보여질 게시글 개수
		
		String pageNum = request.getParameter("pageNum"); //현재 보여지고 있는 페이지의 넘버값
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int count = 0; //전체 게시글의 개수
		int number = 0; //jsp에서 보여질 넘버링 숫자
		
		int currentPage = Integer.parseInt(pageNum); //현재 보여지고 있는 페이지
		
		BoardDAO boardDAO = new BoardDAO();
		count = boardDAO.getCountAll();
		
		int startRow = (currentPage - 1) * pageSize + 1; //페이지 시작글 번호
		int endRow = currentPage * pageSize; // 페이지 마지막 글번호
		
		ArrayList<BoardDTO> list = boardDAO.getList(startRow, endRow);
		
		number = count - (currentPage - 1) * pageSize; //글 목록에 표시할 글 번호
		
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		RequestDispatcher dis = request.getRequestDispatcher("/audio/boardList.jsp");
		dis.forward(request, response);
		
	}

}
