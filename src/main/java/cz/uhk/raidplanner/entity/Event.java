package cz.uhk.raidplanner.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event {

	@Id
	@GeneratedValue
	private int id;
	private Date date;
	@ManyToOne
	@JoinColumn(name="eventTemplate_id")
	private EventTemplate eventTemplate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User leader;
	
	@ManyToMany
	@JoinTable
	private List<MyCharacter> characters;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public EventTemplate getEventTemplate() {
		return eventTemplate;
	}
	public void setEventTemplate(EventTemplate eventTemplate) {
		this.eventTemplate = eventTemplate;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public List<MyCharacter> getCharacters() {
		return characters;
	}
	public void setCharacters(List<MyCharacter> characters) {
		this.characters = characters;
	}
	
}
