package com.tracycle.recycle.domain;

public class ResultVO {
	private int resultId;
	private int price;
	private String standard;
	private String description;
	
	
	private CategoryVO category;
	private AreaVO area;
	
	public ResultVO() { }

	public ResultVO(int resultId, int price, String standard, String description) {
		super();
		this.resultId = resultId;
		this.price = price;
		this.standard = standard;
		this.description = description;
	}

	public ResultVO(int resultId, int price, String standard, String description, CategoryVO category, AreaVO area) {
		super();
		this.resultId = resultId;
		this.price = price;
		this.standard = standard;
		this.description = description;
		this.category = category;
		this.area = area;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public AreaVO getArea() {
		return area;
	}

	public void setArea(AreaVO area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "ResultVO [resultId=" + resultId + ", price=" + price + ", standard=" + standard + ", description="
				+ description + ", category=" + category + ", area=" + area + "]";
	}

	
	
	
	
}
