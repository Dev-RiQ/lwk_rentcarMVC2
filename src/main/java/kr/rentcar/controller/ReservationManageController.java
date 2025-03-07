package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.dto.RentInfo;

public class ReservationManageController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<RentInfo> list = ReservationDAO.getInstance().getAllReservationList();
		if(list == null || list.size() == 0)
			request.setAttribute("rentList", null);
		else
			request.setAttribute("rentList", list);
		return "adminReservationList";
	}
}
