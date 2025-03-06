package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dto.Rentcar;
import kr.rentcar.utils.ScriptAlert;

public class RentcarManageController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!request.getSession().getAttribute("log").equals(1)) {
			ScriptAlert.getInstance().goBackWithMsg(response, "올바르지 않은 접근입니다.");
			return null;
		}
		
		List<Rentcar> list = RentcarDAO.getInstance().getRentcarList();
		request.setAttribute("rentcarList", list);
		return "adminRentcarList";
	}

}
