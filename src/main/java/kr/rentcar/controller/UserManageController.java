package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		
		List<User> list = UserDAO.getInstance().getUserList();
		request.setAttribute("userList", list);
		return "adminUserList";
	}

}
