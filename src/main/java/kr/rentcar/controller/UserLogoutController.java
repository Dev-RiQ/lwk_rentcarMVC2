package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserLogoutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO.getInstance().logout();
		request.getSession().removeAttribute("log");
		String msg = "로그아웃 되었습니다.";
		ScriptAlert.getInstance().goHomeWithMsg(response, request, msg);
		return null;
	}

}
