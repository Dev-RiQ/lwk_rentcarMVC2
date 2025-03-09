package kr.rentcar.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.rentcar.dto.RentInfo;
import kr.rentcar.dto.RentInfoDetail;
import kr.rentcar.dto.Rentcar;
import kr.rentcar.dto.Reservation;
import kr.rentcar.utils.MybatisConfig;

public class ReservationDAO {
	private ReservationDAO() {}
	private static ReservationDAO instance;
	public static ReservationDAO getInstance() {
		if(instance == null) instance = new ReservationDAO();
		return instance;
	}
	public List<RentInfo> getReservationList(int log,int curPage) {
		List<RentInfo> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("getReservationList", log);
			calcEndDay(list);
			int startIdx = (curPage - 1) * 10;
			int endIdx = startIdx + 10;
			if(list.size() <= endIdx) endIdx = list.size();
			list = list.subList(startIdx, endIdx);
		} catch (Exception e) {
			System.out.println("getReservationList error");
			e.printStackTrace();
		}
		return list;
	}
	private int getCntAllRentByLog(int log) {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getCntAllRentByLog", log);
		}catch (Exception e) {
			System.out.println("getCntAllRentByLog Fail");
		}
		return cnt;
	}
	public int getLastPageByLog(int log) {
		return (getCntAllRentByLog(log) + 9) / 10;
	}
	private int getCntAllRent() {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getCntAllRent");
		}catch (Exception e) {
			System.out.println("getCntAllRent Fail");
		}
		return cnt;
	}
	public int getLastPage() {
		return (getCntAllRent() + 9) / 10;
	}
	public List<RentInfo> getAllReservationList(int curPage) {
		List<RentInfo> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("getAllReservationList");
			calcEndDay(list);
			int startIdx = (curPage - 1) * 10;
			int endIdx = startIdx + 10;
			if(list.size() <= endIdx) endIdx = list.size();
			list = list.subList(startIdx, endIdx);
		} catch (Exception e) {
			System.out.println("getAllReservationList error");
			e.printStackTrace();
		}
		return list;
	}
	private void calcEndDay(List<RentInfo> list) {
		for(int i = 0;  i< list.size() ; i++) {
			String day = list.get(i).getRday();
			LocalDate ldt = LocalDate.parse(day);
			ldt = ldt.plusDays(list.get(i).getDday());
			list.get(i).setEday(ldt.toString());
		}
	}
	public void deleteAllReservation(int log) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			List<Reservation> list = session.selectList("getAllReservationByLog",log);
			for(Reservation r : list) {
				int seq = r.getReserve_seq();
				int qty = r.getQty();
				setTotalQty(session, seq, qty);
				session.delete("deleteAReservation", seq);
			}
			session.commit();
		} catch (Exception e) {
			System.out.println("getAllReservationByLog error");
		}
	}
	public void deleteAllReservationByNum(int num) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			List<Reservation> list = session.selectList("getAllReservationByNum",num);
			for(Reservation r : list) {
				int seq = r.getReserve_seq();
				session.delete("deleteAReservation", seq);
			}
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAllReservationByNum error");
		}
	}
	public void deleteAReservation(int seq) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			int qty = session.selectOne("getQty",seq);
			setTotalQty(session, seq, qty);
			session.delete("deleteAReservation", seq);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAReservation error");
		}
	}
	public RentInfoDetail getAReservationInfo(int seq) {
		RentInfoDetail detail = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			detail = session.selectOne("getARentInfoDetail", seq);
			detail.setEday(getCalcEday(detail.getRday(),detail.getDday()));
		} catch (Exception e) {
			System.out.println("getAReservationInfo error");
		}
		return detail;
	}
	private String getCalcEday(String rday, int addDay) {
		LocalDate ldt = LocalDate.parse(rday);
		ldt = ldt.plusDays(addDay);
		return ldt.toString();
	}
	public void addAReservation(int num, String userid, int qty, int dday, String rday, int usein, int usewifi,
			int usenavi, int useseat) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.insert("addAReservation", new Reservation(0, num, userid, qty, dday, rday, usein, usewifi, usenavi, useseat));
			int seq = session.selectOne("getSeq");
			setTotalQty(session, seq, -qty);
			session.commit();
		} catch (Exception e) {
			System.out.println("getCalcEday error");
			e.printStackTrace();
		}
	}
	public int getSeq() {
		int seq = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			seq = session.selectOne("getSeq");
		} catch (Exception e) {
			System.out.println("getSeq error");
		}
		return seq;
	}
	public void updateReservation(int seq, int qty, int dday, int usein, int usewifi, int usenavi, int useseat) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			int nowQty = session.selectOne("getRentcarQty",seq);
			session.update("updateReservation", new Reservation(seq, 0, "", qty, dday, "", usein, usewifi, usenavi, useseat));
			if(nowQty != qty)
				setTotalQty(session, seq, nowQty - qty);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateReservation error");
		}
	}
	private void setTotalQty(SqlSession session, int seq, int qty) throws Exception{
		int num = session.selectOne("getRentcarNum",seq);
		int totalQty = session.selectOne("getRentcarTotalQty",seq);
		totalQty += qty;
		session.update("updateTotalQty", new Rentcar(num, "", 0, 0, 0, totalQty, "", "", ""));
	}
}
