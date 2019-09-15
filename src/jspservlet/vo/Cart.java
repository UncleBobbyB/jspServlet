package jspservlet.vo;

public class Cart {
	private String GoodName;
	public String getGoodName() {
		return GoodName;
	}
	public void setGoodName(String goodName) {
		GoodName = goodName;
	}
	public String getGoodNumber() {
		return GoodNumber;
	}
	public void setGoodNumber(String goodNumber) {
		GoodNumber = goodNumber;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	private String GoodNumber;
	private String Price;
	private String unitPrice;
	
}
