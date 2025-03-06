package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dto.Rentcar;

public class RentcarListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int category = 0;
		if(request.getParameter("category") != null)
			category = Integer.parseInt(request.getParameter("category"));
		List<Rentcar> list = RentcarDAO.getInstance().getRentcarList(category);
		request.setAttribute("rentcarList", list);
		request.setAttribute("category", category);
		return "rentcarList";
	}

}
