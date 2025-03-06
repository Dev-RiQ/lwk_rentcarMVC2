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
	public List<Rentcar> getRentcarList(int category) {
		List<Rentcar> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			if(category == 0)
				list = session.selectList("getAllRentcarList");
			else
				list = session.selectList("getRentcarList", category);
		} catch (Exception e) {
			System.out.println("getRentcarList error");
		}
		return list;
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
}
