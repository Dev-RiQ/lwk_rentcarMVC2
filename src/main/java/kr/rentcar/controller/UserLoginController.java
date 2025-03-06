package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserLoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("loginId") == null)
			return "userLoginForm";
		
		String id = request.getParameter("loginId");
		String pw= request.getParameter("loginPw");
		if(UserDAO.getInstance().isLoginPass(id,pw)) {
			String msg = id + "님 접속을 환영합니다!";
			request.getSession().setAttribute("log", UserDAO.getInstance().getLog());
			ScriptAlert.getInstance().goHomeWithMsg(response, request, msg);
		}else {
			String msg = "로그인 정보가 일치하지 않습니다.";
			ScriptAlert.getInstance().goBackWithMsg(response, msg);
		}
		return null;
	}

}
