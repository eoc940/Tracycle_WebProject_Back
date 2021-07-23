package com.tracycle.recycle.domain;

import java.util.List;


public class BoardVO {
	private int boardId;
	private String title;
	private String content;
	private String date;
	private int viewCount;
	private String picture;
	private int status;
	
	private UserVO user;
	private AreaVO area;
	private CategoryVO category;
	
	
	public BoardVO() { }
	

	public BoardVO(int boardId, String title, String content, String date, int viewCount, String picture, int status) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.date = date;
		this.viewCount = viewCount;
		this.status = status;
	}
	

	public BoardVO(int boardId, String title, String content, String date, int viewCount, String picture, int status, UserVO user,
			AreaVO area, CategoryVO category) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.date = date;
		this.viewCount = viewCount;
		this.status = status;
		this.user = user;
		this.area = area;
		this.category = category;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getViewCount() {
		return viewCount;
	}


	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	

	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public UserVO getUser() {
		return user;
	}


	public void setUser(UserVO user) {
		this.user = user;
	}


	public AreaVO getArea() {
		return area;
	}


	public void setArea(AreaVO area) {
		this.area = area;
	}


	public CategoryVO getCategory() {
		return category;
	}


	public void setCategory(CategoryVO category) {
		this.category = category;
	}




	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", viewCount=" + viewCount + ", status=" + status + ", user=" + user + ", area=" + area
				+ ", category=" + category + " ]";
	}
	
	
	
	
	
}
