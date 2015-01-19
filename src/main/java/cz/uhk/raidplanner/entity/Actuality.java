package cz.uhk.raidplanner.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Actuality {

	@Id
	@GeneratedValue
	private int id;
	private String header;
	private String text;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User author;
	private Date published;
	private Date edited;
	
	
	public Date getEdited() {
		return edited;
	}
	public void setEdited(Date edited) {
		this.edited = edited;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date date) {
		this.published = date;
	}
	
}
