	package by.htp.ll.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class News implements Serializable{
	private static final long serialVersionUID = 6490386152310115155L;
	
	private int id;
	private String title;
	private String brief;
	private String content;
	private LocalDate date;
	
	public News() {}
	
	public News(int id, String title, String brief) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
	}
	
	public News(int id, String title, String brief, String content, LocalDate date) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + id;
		result = 31 * result + (( title == null) ? 0 : title.hashCode());
        return result;    	    
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof News)) {
			return false;
		}
			
		News news = (News) obj;
		return news.id == id && news.title.equals(title);
	}
		
	@Override
	public String toString() {	
		return "id: " + this.id + "\n" +
				"title:" + this.title + "\n" +
	            "brief:" + this.brief + "\n" +
				"content: " + this.content + "\n" + 
				"date: " + this.date + "\n";
	}
	
}
