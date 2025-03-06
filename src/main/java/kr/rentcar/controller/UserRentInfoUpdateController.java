package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserRentInfoUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("updateSeq"));
		int qty = Integer.parseInt(request.getParameter("updateQty"));
		int dday = Integer.parseInt(request.getParameter("updateDday"));
		int usein = Integer.parseInt(request.getParameter("in"));
		int usewifi = Integer.parseInt(request.getParameter("wifi"));
		int usenavi = Integer.parseInt(request.getParameter("navi"));
		int useseat = Integer.parseInt(request.getParameter("seat"));
		ReservationDAO.getInstance().updateReservation(seq,qty,dday,usein,usewifi,usenavi,useseat);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "예약 정보 수정이 완료되었습니다.", "userRentInfo.do?seq="+seq);
		return null;
	}

}
