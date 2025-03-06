package kr.rentcar.dto;

public class Rentcar {
	private	int num;
	private String name;
	private int category;
	private int price;
	private int usepeople;
	private int total_qty;
	private String company;
	private String img;
	private String info;
	public Rentcar(int num, String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		super();
		this.num = num;
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Rentcar [num=" + num + ", name=" + name + ", category=" + category + ", price=" + price + ", usepeople="
				+ usepeople + ", total_qty=" + total_qty + ", company=" + company + ", img=" + img + ", info=" + info
				+ "]";
	}
	
}
