package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
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
		int curPage = 1;
		if(request.getParameter("curpage") != null)
			curPage = Integer.parseInt(request.getParameter("curpage"));
		List<Rentcar> list = RentcarDAO.getInstance().getRentcarListByCurpage(curPage);
		if(list == null || list.size() == 0)
			request.setAttribute("rentcarList", null);
		else
			request.setAttribute("rentcarList", list);
		int minPage = BoardDAO.getInstance().getMinPage(curPage);
		int lastPage = RentcarDAO.getInstance().getLastPage();
		request.setAttribute("curpage", curPage);
		request.setAttribute("minpage", minPage);
		request.setAttribute("lastpage", lastPage);
		return "adminRentcarList";
	}

}
