package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dto.Board;
import kr.rentcar.utils.FileUtil;
import kr.rentcar.utils.ScriptAlert;

public class BoardUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("check");
		int board_num = Integer.parseInt(request.getParameter("boardNum"));
		if(name == null) {
			Board board = BoardDAO.getInstance().getABoard(board_num);
			request.setAttribute("board", board);
			request.setAttribute("name", RentcarDAO.getInstance().getCarNameByNum(board.getNum()));
			return "boardUpdateForm";
		}
		
		String[] values = FileUtil.getPartsValue(request, response);
		if(!values[5].isBlank()) {
			String filename = BoardDAO.getInstance().getBoardFileName(board_num);
			if(filename != null && !filename.isBlank())
				FileUtil.deleteFile(request, filename);
		} else
			values[5] = null;
		BoardDAO.getInstance().updateBoard(board_num,
											Integer.parseInt(values[2]),
											values[3],
											values[4],
											values[5]);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "게시글이 수정되었습니다.", "boardContent.do?num="+board_num);
		return null;
	}
}
