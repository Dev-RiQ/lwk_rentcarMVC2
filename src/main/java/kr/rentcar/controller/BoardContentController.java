package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.dto.Board;

public class BoardContentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_num = 0;
		if(request.getParameter("num") == null)
			board_num = BoardDAO.getInstance().getLastBoardNum();
		else
			board_num = Integer.parseInt(request.getParameter("num"));
		Board board = BoardDAO.getInstance().getABoard(board_num);
		String carName = RentcarDAO.getInstance().getCarNameByNum(board.getNum());
		int num = UserDAO.getInstance().getNumById(board.getUserid());
		request.setAttribute("board", board);
		request.setAttribute("carName", carName);
		request.setAttribute("num", num);
		return "boardContentForm";
	}
}
