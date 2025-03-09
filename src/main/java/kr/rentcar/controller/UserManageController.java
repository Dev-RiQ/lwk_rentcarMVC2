package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.dto.User;
import kr.rentcar.utils.ScriptAlert;

public class UserManageController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!request.getSession().getAttribute("log").equals(1)) {
			ScriptAlert.getInstance().goBackWithMsg(response, "올바르지 않은 접근입니다.");
			return null;
		}
		int curPage = 1;
		if(request.getParameter("curpage") != null)
			curPage = Integer.parseInt(request.getParameter("curpage"));
		List<User> list = UserDAO.getInstance().getUserList(curPage);
		if(list == null || list.size() == 0)
			request.setAttribute("userList", null);
		else
			request.setAttribute("userList", list);
		int minPage = BoardDAO.getInstance().getMinPage(curPage);
		int lastPage = UserDAO.getInstance().getLastPage();
		request.setAttribute("boardList", list);
		request.setAttribute("curpage", curPage);
		request.setAttribute("minpage", minPage);
		request.setAttribute("lastpage", lastPage);
		return "adminUserList";
	}

}
