package kr.rentcar.controller;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.dto.RentInfoDetail;
import kr.rentcar.utils.ScriptAlert;

public class RentcarInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log") == null) {
			ScriptAlert.getInstance().goUrlWithMsg(response, request, "로그인 후 이용가능합니다.", "userLogin.do");
			return null;
		}
		int num = Integer.parseInt(request.getParameter("num"));
		RentInfoDetail detail = RentcarDAO.getInstance().getRentcarInfo(num);
		request.setAttribute("detail", detail);
		request.setAttribute("today", LocalDate.now());
		request.setAttribute("reservation", LocalDate.now().plusDays(1));
		request.setAttribute("userid", UserDAO.getInstance().getUserId());
		request.setAttribute("num", num);
		return "rentcarInfo";
	}

}
