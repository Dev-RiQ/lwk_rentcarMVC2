package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.utils.ScriptAlert;

public class UserRentInfoInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("rentNum"));
		String userid = request.getParameter("rentId");
		int qty = Integer.parseInt(request.getParameter("rentQty"));
		int dday = Integer.parseInt(request.getParameter("rentDday"));
		String rday = request.getParameter("rentRday");
		int usein = Integer.parseInt(request.getParameter("in"));
		int usewifi = Integer.parseInt(request.getParameter("wifi"));
		int usenavi = Integer.parseInt(request.getParameter("navi"));
		int useseat = Integer.parseInt(request.getParameter("seat"));
		ReservationDAO.getInstance().addAReservation(num,userid,qty,dday,rday,usein,usewifi,usenavi,useseat);
		int seq = ReservationDAO.getInstance().getSeq();
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "예약이 완료되었습니다.", "userRentInfo.do?seq="+seq);
		return null;
	}

}
