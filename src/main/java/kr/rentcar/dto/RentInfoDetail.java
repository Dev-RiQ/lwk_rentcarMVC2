package kr.rentcar.dto;

public class RentInfoDetail {
	private int reserve_seq;
	private String name;
	private int qty;
	private String rday;
	private String eday;
	private int dday;
	private int usein;
	private int usewifi;
	private int usenavi;
	private int useseat;
	private int category;
	private int price;
	private int usepeople;
	private int total_qty;
	private String company;
	private String img;
	private String info;
	public RentInfoDetail(int num, String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	public RentInfoDetail(int reserve_seq, String name, int qty, String rday, int dday, int usein,
			int usewifi, int usenavi, int useseat, int category, int price, int usepeople, int total_qty,
			String company, String img, String info) {
		super();
		this.reserve_seq = reserve_seq;
		this.name = name;
		this.qty = qty;
		this.rday = rday;
		this.dday = dday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	public int getReserve_seq() {
		return reserve_seq;
	}
	public void setReserve_seq(int reserve_seq) {
		this.reserve_seq = reserve_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public int getUsein() {
		return usein;
	}
	public void setUsein(int usein) {
		this.usein = usein;
	}
	public int getUsewifi() {
		return usewifi;
	}
	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}
	public int getUsenavi() {
		return usenavi;
	}
	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}
	public int getUseseat() {
		return useseat;
	}
	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}
	public String getEday() {
		return eday;
	}
	public void setEday(String eday) {
		this.eday = eday;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUsepeople() {
		return usepeople;
	}
	public void setUsepeople(int usepeople) {
		this.usepeople = usepeople;
	}
	public int getTotal_qty() {
		return total_qty;
	}
	public void setTotal_qty(int total_qty) {
		this.total_qty = total_qty;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "RentInfoDetail [reserve_seq=" + reserve_seq + ", name=" + name + ", qty=" + qty + ", rday=" + rday
				+ ", eday=" + eday + ", dday=" + dday + ", usein=" + usein + ", usewifi=" + usewifi + ", usenavi="
				+ usenavi + ", useseat=" + useseat + ", category=" + category + ", price=" + price + ", usepeople="
				+ usepeople + ", total_qty=" + total_qty + ", company=" + company + ", img=" + img + ", info=" + info
				+ "]";
	}
	
}
