package model;


public class Message {
	private int id;
	private String author;
	private String text;
	private String time;
	
	
	public Message(int id, String author, String text) {
		this.author = author;
		this.text = text;
		this.time = java.time.LocalDateTime.now().toString();
		this.id = id;
	}

	
	public int getId() {
		return id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getText() {
		return text;
	}
	
	public String getTime() {
		return time;
	}
	
}
