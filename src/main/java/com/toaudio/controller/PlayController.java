package com.toaudio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toaudio.dao.BoardDAO;
import com.toaudio.dto.BoardDTO;

public class PlayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	public void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int no = Integer.parseInt(request.getParameter("codenum"));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO player = boardDAO.getAudio(no);
		
		request.setAttribute("player", player);
		
		RequestDispatcher dis = request.getRequestDispatcher("/audio/player.jsp");
		dis.forward(request, response);
	}
}
