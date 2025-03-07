package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.utils.FileUtil;
import kr.rentcar.utils.ScriptAlert;

public class RentcarInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("check");
		if(name == null) {
			request.setAttribute("img", "logo.png");
			return "adminRentcarContentForm";
		}
		
		String[] values = FileUtil.getPartsValue(request, response);
		RentcarDAO.getInstance().insertRentcar(values[0],
												Integer.parseInt(values[1]),
												Integer.parseInt(values[2]),
												Integer.parseInt(values[3]),
												Integer.parseInt(values[4]),
												values[5],
												values[7],
												values[6]);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "차량 추가가 완료되었습니다.", "rentcarManage.do");
		return null;
	}

}
