package com.amirinator.model;

public class Message {

	private String content;
	private Integer columnWidth;

	private Message() {
		//default so values must be set
	}

	public Message(String message, Integer cWidth) {
		content = message;
		columnWidth = cWidth;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String message) {
		this.content = message;
	}

	public Integer getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(Integer columnWidth) {
		this.columnWidth = columnWidth;
	}
}
