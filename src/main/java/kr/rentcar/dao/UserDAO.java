package kr.rentcar.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.rentcar.dto.User;
import kr.rentcar.utils.MybatisConfig;

public class UserDAO {
	private UserDAO() {}
	int log;
	private static UserDAO instance;
	public static UserDAO getInstance() {
		if(instance == null) instance = new UserDAO();
		return instance;
	}
	
	public int getLog() {
		return log;
	}

	public void setLog(int log) {
		this.log = log;
	}

	public boolean isLoginPass(String id , String pw) {
		int num = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			num = session.selectOne("isLoginPass", new User(0, "", id, pw, "", ""));
			log = num;
		}catch (Exception e) {
			System.out.println("Login Fail");
		}
		return num != 0;
	}
	
	public void logout() {
		log = 0;
	}

	public void insertUser(String name, String userid, String pwd, String email, String phone) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.insert("insertUser", new User(0, name, userid, pwd, email, phone));
			session.commit();
		}catch (Exception e) {
			System.out.println("Insert Fail");
		}
	}
	
	public User getAUser(int log) {
		User user = null;
		if(log == 0) log = this.log;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			user = session.selectOne("getAUser", log);
		}catch (Exception e) {
			System.out.println("Get A User Fail");
		}
		return user;
	}
	
	public void updateUser(String email, String phone) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.update("updateUser", new User(log, "", "", "", email, phone));
			session.commit();
		}catch (Exception e) {
			System.out.println("Update A User Fail");
		}
	}
	
	public void deleteUser(int log) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.delete("deleteUser", log);
			session.commit();
		}catch (Exception e) {
			System.out.println("Delete A User Fail");
		}
	}

	public String getUserId() {
		String userid = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			userid = session.selectOne("getUserId", log);
		}catch (Exception e) {
			System.out.println("Get UserId Fail");
		}
		return userid;
	}

	public List<User> getUserList() {
		List<User> list= null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("getAllUser");
		}catch (Exception e) {
			System.out.println("getUserList Fail");
		}
		return list;
	}
}
