package model;

public class message {
	private String id;
	private String content;
	public message(String id, String content, String date, String email) {
		this.id = id;
		this.content = content;
		this.date = date;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String date;
	private String email;

}
