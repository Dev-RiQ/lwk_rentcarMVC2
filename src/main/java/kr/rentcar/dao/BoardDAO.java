package kr.rentcar.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.rentcar.dto.Board;
import kr.rentcar.dto.User;
import kr.rentcar.utils.MybatisConfig;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO instance;
	public static BoardDAO getInstance() {
		if(instance == null) instance = new BoardDAO();
		return instance;
	}

	public boolean isLoginPass(String id , String pw) {
		int num = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			num = session.selectOne("isLoginPass", new User(0, "", id, pw, "", ""));
		}catch (Exception e) {
			System.out.println("Login Fail");
		}
		return num != 0;
	}

	public List<Board> getPagingBoard(int category, int curPage) {
		List<Board> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("getAllBoardIncategory", category);
			int startIdx = (curPage - 1) * 10;
			int endIdx = startIdx + 10;
			if(list.size() <= endIdx) endIdx = list.size();
			list = list.subList(startIdx, endIdx);
		}catch (Exception e) {
			System.out.println("getPagingBoard Fail");
		}
		return list;
	}
	
	private int getCntAllBoardByCategory(int category) {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getCntAllBoardByCategory", category);
		}catch (Exception e) {
			System.out.println("getCntAllBoardByCategory Fail");
		}
		return cnt;
	}

	public int getMinPage(int curPage) {
		return curPage - curPage % 5 + 1;
	}

	public int getLastPage(int category) {
		return (getCntAllBoardByCategory(category) + 9) / 10;
	}

	public Board getABoard(int board_num) {
		Board board = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			board = session.selectOne("getABoard", board_num);
		}catch (Exception e) {
			System.out.println("getABoard Fail");
		}
		return board;
	}

	public int getLastBoardNum() {
		int num = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			num = session.selectOne("getLastBoardNum");
		}catch (Exception e) {
			System.out.println("getLastBoardNum Fail");
		}
		return num;
	}

	public void insertBoard(int category, String userid, int num, int score, String title, String content, String img) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss"));
			if(category != 2) {
				num = 0;
				score = 0;
			}
			session.insert("insertBoard", new Board(0, category, userid, num, title, score, content, img, datetime));
			session.commit();
		}catch (Exception e) {
			System.out.println("insertBoard Fail");
		}
	}

	public void updateBoard(int board_num, int score, String title, String content, String img) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			if(img == null)
				session.update("updateBoardImgNull", new Board(board_num, 0, "", 0, title, score, content, "", ""));
			else
				session.update("updateBoard", new Board(board_num, 0, "", 0, title, score, content, img, ""));
			session.commit();
		}catch (Exception e) {
			System.out.println("updateBoard Fail");
		}
	}

	public String getBoardFileName(int board_num) {
		String filename = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			filename = session.selectOne("getBoardFileName", board_num);
		}catch (Exception e) {
			System.out.println("getBoardFileName Fail");
		}
		return filename;
	}

	public void deleteABoard(int board_num) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.delete("deleteABoard", board_num);
			session.commit();
		}catch (Exception e) {
			System.out.println("deleteABoard Fail");
		}
	}

	public List<Board> getAllBoard(int curPage) {
		List<Board> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("getAllBoard");
			int startIdx = (curPage - 1) * 10;
			int endIdx = startIdx + 10;
			if(list.size() <= endIdx) endIdx = list.size();
			list = list.subList(startIdx, endIdx);
		}catch (Exception e) {
			System.out.println("getAllBoard Fail");
		}
		return list;
	}

	public int getLastPage() {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getCntAllBoard");
		}catch (Exception e) {
			System.out.println("getCntAllBoard Fail");
		}
		return (cnt + 9) / 10;
	}
}