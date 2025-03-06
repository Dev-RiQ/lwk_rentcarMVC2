package kr.rentcar.frontcontroller;

import java.util.HashMap;

import kr.rentcar.controller.Controller;
import kr.rentcar.controller.RentcarDeleteController;
import kr.rentcar.controller.RentcarInfoController;
import kr.rentcar.controller.RentcarInsertController;
import kr.rentcar.controller.RentcarListController;
import kr.rentcar.controller.RentcarManageController;
import kr.rentcar.controller.RentcarUpdateController;
import kr.rentcar.controller.UserContentController;
import kr.rentcar.controller.UserDeleteController;
import kr.rentcar.controller.UserInsertController;
import kr.rentcar.controller.UserLoginController;
import kr.rentcar.controller.UserLogoutController;
import kr.rentcar.controller.UserManageController;
import kr.rentcar.controller.UserRentInfoInsertController;
import kr.rentcar.controller.UserRentInfoController;
import kr.rentcar.controller.UserRentInfoDeleteController;
import kr.rentcar.controller.UserRentInfoUpdateController;
import kr.rentcar.controller.UserRentListController;
import kr.rentcar.controller.UserRentListDeleteController;
import kr.rentcar.controller.UserUpdateController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/userLogin.do",new UserLoginController());
		mappings.put("/userLogout.do",new UserLogoutController());
		mappings.put("/userContent.do",new UserContentController());
		mappings.put("/userRentInfo.do",new UserRentInfoController());
		mappings.put("/userRentList.do",new UserRentListController());
		mappings.put("/userRentInfoDelete.do",new UserRentInfoDeleteController());
		mappings.put("/userRentListDelete.do",new UserRentListDeleteController());
		mappings.put("/userRentInfoInsert.do",new UserRentInfoInsertController());
		mappings.put("/userRentInfoUpdate.do",new UserRentInfoUpdateController());
		mappings.put("/userInsert.do",new UserInsertController());
		mappings.put("/userDelete.do",new UserDeleteController());
		mappings.put("/userUpdate.do",new UserUpdateController());
		mappings.put("/userManage.do",new UserManageController());
		
		mappings.put("/rentcarInfo.do",new RentcarInfoController());
		mappings.put("/rentcarList.do",new RentcarListController());
		mappings.put("/rentcarInsert.do",new RentcarInsertController());
		mappings.put("/rentcarDelete.do",new RentcarDeleteController());
		mappings.put("/rentcarUpdate.do",new RentcarUpdateController());
		mappings.put("/rentcarManage.do",new RentcarManageController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
