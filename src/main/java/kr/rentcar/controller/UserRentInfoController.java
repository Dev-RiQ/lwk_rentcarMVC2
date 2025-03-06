package kr.rentcar.controller;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.dto.RentInfoDetail;

public class UserRentInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("seq") == null)
			return "userRentList";
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		RentInfoDetail detail = ReservationDAO.getInstance().getAReservationInfo(seq);
		request.setAttribute("detail", detail);
		request.setAttribute("reservation", LocalDate.now().plusDays(1));
		return "userRentInfo";	
	}

}
