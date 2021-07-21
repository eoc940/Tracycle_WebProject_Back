package com.tracycle.recycle.domain;

public class CommentVO {
	private int commentId;
	private String date;
	private String content;
	private int secret;
	
	private UserVO user;
	private BoardVO board;
	
	public CommentVO() { }

	public CommentVO(int commentId, String date, String content, int secret) {
		super();
		this.commentId = commentId;
		this.date = date;
		this.content = content;
		this.secret = secret;
	}

	public CommentVO(int commentId, String date, String content, int secret, UserVO user, BoardVO board) {
		super();
		this.commentId = commentId;
		this.date = date;
		this.content = content;
		this.secret = secret;
		this.user = user;
		this.board = board;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", date=" + date + ", content=" + content + ", secret=" + secret
				+ ", user=" + user + ", board=" + board + "]";
	}
	
	
	
}
