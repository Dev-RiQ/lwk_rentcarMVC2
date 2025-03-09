package kr.rentcar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.BoardDAO;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.dto.RentInfo;
import kr.rentcar.utils.ScriptAlert;

public class UserRentListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log") == null) {
			ScriptAlert.getInstance().goUrlWithMsg(response, request, "로그인 후 이용가능합니다.", "userLogin.do");
			return null;
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		int curPage = 1;
		if(request.getParameter("curpage") != null)
			curPage = Integer.parseInt(request.getParameter("curpage"));
		List<RentInfo> list = ReservationDAO.getInstance().getReservationList(log, curPage);
		if(list == null || list.size() == 0)
			request.setAttribute("rentList", null);
		else
			request.setAttribute("rentList", list);
		int minPage = BoardDAO.getInstance().getMinPage(curPage);
		int lastPage = ReservationDAO.getInstance().getLastPageByLog(log);
		request.setAttribute("boardList", list);
		request.setAttribute("curpage", curPage);
		request.setAttribute("minpage", minPage);
		request.setAttribute("lastpage", lastPage);
		return "userRentList";
	}

}
