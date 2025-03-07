package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dto.Rentcar;
import kr.rentcar.utils.FileUtil;
import kr.rentcar.utils.ScriptAlert;

public class RentcarUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("check");
		int num = Integer.parseInt(request.getParameter("num"));
		if(name == null) {
			Rentcar rentcar = RentcarDAO.getInstance().getRentcarByNum(num);
			request.setAttribute("car", rentcar);
			return "adminRentcarUpdateForm";
		}
		
		String[] values = FileUtil.getPartsValue(request, response);
		if(!values[8].isBlank())
			FileUtil.deleteFile(request, RentcarDAO.getInstance().getFilename(num));
		else
			values[8] = null;
		RentcarDAO.getInstance().updateRentcar(Integer.parseInt(values[0]),
												values[1],
												Integer.parseInt(values[2]),
												Integer.parseInt(values[3]),
												Integer.parseInt(values[4]),
												Integer.parseInt(values[5]),
												values[6],
												values[8],
												values[7]);
		ScriptAlert.getInstance().goUrlWithMsg(response, request, "차량 정보 수정이 완료되었습니다.", "rentcarManage.do");
		return null;
	}

}
