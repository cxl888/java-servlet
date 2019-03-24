package cn.itcast.demo06_domain;

public class Product {
    private int pid;
    private String pname;
    private double market_price;
    private double shop_price;
    private String imageurl;
    private String pdesc;
    private String category;
    private double oil;
    private double displacement;
    private int rank;
    
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getOil() {
		return oil;
	}
	public void setOil(double oil) {
		this.oil = oil;
	}
	public double getDisplacement() {
		return displacement;
	}
	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
