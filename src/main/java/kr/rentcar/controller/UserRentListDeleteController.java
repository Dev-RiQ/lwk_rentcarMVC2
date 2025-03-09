package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserRentListDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		ReservationDAO.getInstance().deleteAllReservation(log);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "모든 예약이 취소되었습니다.", "userRentList.do?curpage=1");
		return null;
	}

}
