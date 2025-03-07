package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.utils.FileUtil;
import kr.rentcar.utils.ScriptAlert;

public class BoardInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("check");
		if(name == null) {
			request.setAttribute("carList", RentcarDAO.getInstance().getRentcarList());
			return "boardInsertForm";
		}
		String userid = UserDAO.getInstance().getUserId();
		String[] values = FileUtil.getPartsValue(request, response);
		BoardDAO.getInstance().insertBoard(Integer.parseInt(values[0]),
											userid,
											Integer.parseInt(values[1]),
											Integer.parseInt(values[2]),
											values[3],
											values[4],
											values[5]);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "게시글이 추가되었습니다.", "boardContent.do");
		return null;
	}
}
