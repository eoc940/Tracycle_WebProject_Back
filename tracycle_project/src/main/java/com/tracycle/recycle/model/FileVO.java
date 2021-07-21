package com.tracycle.recycle.model;

public class FileVO {
	private int fileId;
	private String originalFileName;
	private String fileName;
	private String filePath;
	
	private BoardVO board;

	public FileVO() { }

	
	public FileVO(int fileId, String originalFileName, String fileName, String filePath) {
		super();
		this.fileId = fileId;
		this.originalFileName = originalFileName;
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public FileVO(int fileId, String originalFileName, String fileName, String filePath, BoardVO board) {
		super();
		this.fileId = fileId;
		this.originalFileName = originalFileName;
		this.fileName = fileName;
		this.filePath = filePath;
		this.board = board;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "FileVO [fileId=" + fileId + ", originalFileName=" + originalFileName + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", board=" + board + "]";
	}
	
	
	
	
	
}
