package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserRentInfoDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		ReservationDAO.getInstance().deleteAReservation(seq);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "예약이 취소되었습니다.", "userRentList.do");
		return null;
	}

}
