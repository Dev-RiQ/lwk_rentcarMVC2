package kr.rentcar.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.rentcar.dto.RentInfoDetail;
import kr.rentcar.dto.Rentcar;
import kr.rentcar.utils.MybatisConfig;

public class RentcarDAO {
	private RentcarDAO() {}
	private static RentcarDAO instance;
	public static RentcarDAO getInstance() {
		if(instance == null) instance = new RentcarDAO();
		return instance;
	}
	public List<Rentcar> getRentcarList(int category, int curPage) {
		List<Rentcar> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			if(category == 0)
				list = session.selectList("getAllRentcarList");
			else
				list = session.selectList("getRentcarList", category);
			int startIdx = (curPage - 1) * 9;
			int endIdx = startIdx + 9;
			if(list.size() <= endIdx) endIdx = list.size();
			list = list.subList(startIdx, endIdx);
		} catch (Exception e) {
			System.out.println("getRentcarList error");
		}
		return list;
	}
	public List<Rentcar> getRentcarListByCurpage(int curPage) {
		List<Rentcar> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("getAllRentcarList");
			int startIdx = (curPage - 1) * 9;
			int endIdx = startIdx + 9;
			if(list.size() <= endIdx) endIdx = list.size();
			list = list.subList(startIdx, endIdx);
		} catch (Exception e) {
			System.out.println("getRentcarListByCurpage error");
		}
		return list;
	}
	private int getCntAllCar(int category) {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getCntAllCarByCategory", category);
		}catch (Exception e) {
			System.out.println("getCntAllCarByCategory Fail");
		}
		return cnt;
	}
	public int getLastPageByCategory(int category) {
		return (getCntAllCar(category) + 8) / 9;
	}
	private int getCntAllCar() {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getCntAllCar");
		}catch (Exception e) {
			System.out.println("getCntAllCar Fail");
		}
		return cnt;
	}
	public int getLastPage() {
		return (getCntAllCar() + 8) / 9;
	}
	public RentInfoDetail getRentcarInfo(int num) {
		RentInfoDetail detail = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			detail = session.selectOne("getARentcarInfo", num);
		} catch (Exception e) {
			System.out.println("getRentcarInfo error");
		}
		return detail;
	}
	public List<Rentcar> getRentcarList() {
		List<Rentcar> list= null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("getAllRentcar");
		}catch (Exception e) {
			System.out.println("getRentcarList Fail");
		}
		return list;
	}
	public void insertRentcar(String name, int category, int price, int usepeople, int total_qty, String company, String img,
			String info) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.insert("insertRentcar", new Rentcar(0, name, category, price, usepeople, total_qty, company, img, info));
			session.commit();
		}catch (Exception e) {
			System.out.println("insertRentcar Fail");
		}
	}
	public void updateRentcar(int num, String name, int category, int price, int usepeople, int total_qty, String company, String img,
			String info) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			if(img == null)
				session.update("updateRentcarNoImg", new Rentcar(num, name, category, price, usepeople, total_qty, company, img, info));
			else {
				session.update("updateRentcarHasImg", new Rentcar(num, name, category, price, usepeople, total_qty, company, img, info));
			}
			session.commit();
		}catch (Exception e) {
			System.out.println("updateRentcar Fail");
			e.printStackTrace();
		}
	}
	public String getFilenameAndDeleteCar(int num) {
		String filename = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			filename = session.selectOne("getFilename", num);
			session.delete("deleteCar", num);
			session.commit();
		}catch (Exception e) {
			System.out.println("getFilenameAndDeleteCar Fail");
		}
		return filename;
	}
	public Rentcar getRentcarByNum(int num) {
		Rentcar rentcar = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			rentcar = session.selectOne("getRentcarByNum", num);
		}catch (Exception e) {
			System.out.println("getRentcarByNum Fail");
		}
		return rentcar;
	}
	public String getFilename(int num) {
		String filename = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			filename = session.selectOne("getFilename", num);
		}catch (Exception e) {
			System.out.println("getFilename Fail");
		}
		return filename;
	}
	public String getCarNameByNum(int num) {
		String carName = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			carName = session.selectOne("getCarNameByNum", num);
		}catch (Exception e) {
			System.out.println("getCarNameByNum Fail");
		}
		return carName;
	}
}
