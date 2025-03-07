package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dto.Board;

public class BoardPagingController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int category = Integer.parseInt(request.getParameter("category"));
		int curPage = Integer.parseInt(request.getParameter("curpage"));
		List<Board> list= BoardDAO.getInstance().getPagingBoard(category, curPage);
		int minPage = BoardDAO.getInstance().getMinPage(curPage);
		int lastPage = BoardDAO.getInstance().getLastPage(category);
		request.setAttribute("boardList", list);
		request.setAttribute("category", category);
		request.setAttribute("curpage", curPage);
		request.setAttribute("minpage", minPage);
		request.setAttribute("lastpage", lastPage);
		return "boardPaging";
	}
}
