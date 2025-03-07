package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.utils.FileUtil;
import kr.rentcar.utils.ScriptAlert;

public class RentcarDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String filename = RentcarDAO.getInstance().getFilenameAndDeleteCar(num);
		FileUtil.deleteFile(request, filename);
		ReservationDAO.getInstance().deleteAllReservationByNum(num);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "삭제가 완료되었습니다.", "rentcarManage.do");		
		return null;
	}
}
