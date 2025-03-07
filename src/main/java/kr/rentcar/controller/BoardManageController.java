package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dto.Board;

public class BoardManageController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curPage = Integer.parseInt(request.getParameter("curpage"));
		List<Board> list = BoardDAO.getInstance().getAllBoard(curPage);
		int minPage = BoardDAO.getInstance().getMinPage(curPage);
		int lastPage = BoardDAO.getInstance().getLastPage();
		request.setAttribute("boardList", list);
		request.setAttribute("curpage", curPage);
		request.setAttribute("minpage", minPage);
		request.setAttribute("lastpage", lastPage);
		request.setAttribute("boardList", list);
		return "adminBoardList";
	}
}
