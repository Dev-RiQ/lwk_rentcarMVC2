package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dto.Rentcar;

public class RentcarListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int category = 0;
		if(request.getParameter("category") != null)
			category = Integer.parseInt(request.getParameter("category"));
		int curPage = 1;
		if(request.getParameter("curpage") != null)
			curPage = Integer.parseInt(request.getParameter("curpage"));
		request.setAttribute("category", category);
		List<Rentcar> list = RentcarDAO.getInstance().getRentcarList(category, curPage);
		if(list == null || list.size() == 0)
			request.setAttribute("rentcarList", null);
		else
			request.setAttribute("rentcarList", list);
		int minPage = BoardDAO.getInstance().getMinPage(curPage);
		int lastPage = RentcarDAO.getInstance().getLastPage();
		if(category > 0)
			lastPage = RentcarDAO.getInstance().getLastPageByCategory(category);
		request.setAttribute("curpage", curPage);
		request.setAttribute("minpage", minPage);
		request.setAttribute("lastpage", lastPage);
		return "rentcarList";
	}

}
