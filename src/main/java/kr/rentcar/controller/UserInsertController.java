package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("insertId") == null)
			return "userInsertForm";
		
		String name = request.getParameter("insertName");
		String userid = request.getParameter("insertId");
		String pwd = request.getParameter("insertPw");
		String email = request.getParameter("insertEmail");
		String phone = request.getParameter("insertPhone");
		UserDAO.getInstance().insertUser(name,userid,pwd,email,phone);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, 
				userid + "님 가입을 환영합니다!\\n 로그인 페이지로 이동합니다.", "userLogin.do");
		return null;
	}

}
