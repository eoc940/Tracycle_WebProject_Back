package com.tracycle.recycle.model;

public class ResultVO {
	private int resultId;
	private int price;
	private String standard;
	private String description;
	private String url;
	private String telephone;
	
	private CategoryVO category;
	private AreaVO area;
	
	public ResultVO() { }

	public ResultVO(int resultId, int price, String standard, String description, String url, String telephone) {
		super();
		this.resultId = resultId;
		this.price = price;
		this.standard = standard;
		this.description = description;
		this.url = url;
		this.telephone = telephone;
	}

	public ResultVO(int resultId, int price, String standard, String description, String url, String telephone,
			CategoryVO category, AreaVO area) {
		super();
		this.resultId = resultId;
		this.price = price;
		this.standard = standard;
		this.description = description;
		this.url = url;
		this.telephone = telephone;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
				+ description + ", url=" + url + ", telephone=" + telephone + ", category=" + category + ", area="
				+ area + "]";
	}
	
	
	
	
}
