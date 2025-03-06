package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;

public class UserContentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int log = 0;
		if(request.getParameter("num") != null) 
			log = Integer.parseInt(request.getParameter("num")); 
		request.setAttribute("user", UserDAO.getInstance().getAUser(log));
		return "userContentForm";
	}

}
