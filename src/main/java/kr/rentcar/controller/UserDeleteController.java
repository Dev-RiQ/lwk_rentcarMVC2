package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		if(log == 1)
			log = Integer.parseInt(request.getParameter("num"));
		else {
			request.getSession().removeAttribute("log");
			UserDAO.getInstance().logout();
		}
		ReservationDAO.getInstance().deleteAllReservation(log);
		UserDAO.getInstance().deleteUser(log);
		ScriptAlert.getInstance().goHomeWithMsg(response, request, "회원 탈퇴가 완료되었습니다.");
		return null;
	}

}
