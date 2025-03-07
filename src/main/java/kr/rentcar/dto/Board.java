package kr.rentcar.dto;

public class Board {
	private int board_num;
    private int category;
    private String userid;
    private int num; 
    private String title; 
    private int score; 
    private String content; 
    private String img; 
    private String datetime;
	public Board(int board_num, int category, String userid, int num, String title, int score, String content,
			String img, String datetime) {
		super();
		this.board_num = board_num;
		this.category = category;
		this.userid = userid;
		this.num = num;
		this.title = title;
		this.score = score;
		this.content = content;
		this.img = img;
		this.datetime = datetime;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
    
}
