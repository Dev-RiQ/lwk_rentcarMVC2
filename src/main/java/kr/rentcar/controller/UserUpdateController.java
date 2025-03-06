package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("updateEmail");
		String phone = request.getParameter("updatePhone");
		UserDAO.getInstance().updateUser(email,phone);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "회원 정보 수정이 완료되었습니다.", "userContent.do");
		return null;
	}

}
