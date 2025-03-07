package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.utils.FileUtil;
import kr.rentcar.utils.ScriptAlert;

public class BoardDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_num = Integer.parseInt(request.getParameter("boardNum"));
		String filename = BoardDAO.getInstance().getBoardFileName(board_num);
		if(filename != null && !filename.isBlank())
			FileUtil.deleteFile(request, filename);
		BoardDAO.getInstance().deleteABoard(board_num);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "삭제가 완료되었습니다.", "index.jsp");		
		return null;
	}
}
