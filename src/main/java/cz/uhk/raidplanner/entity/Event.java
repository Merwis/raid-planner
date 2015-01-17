package cz.uhk.raidplanner.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	private String time;
	@ManyToOne
	@JoinColumn(name="eventTemplate_id")
	private EventTemplate eventTemplate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User leader;
	
	@OneToMany(mappedBy="event", cascade=CascadeType.REMOVE)
	private List<CharacterOnEvent> characters;
	
	
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
	public List<CharacterOnEvent> getCharacters() {
		return characters;
	}
	public void setCharacters(List<CharacterOnEvent> characters) {
		this.characters = characters;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
