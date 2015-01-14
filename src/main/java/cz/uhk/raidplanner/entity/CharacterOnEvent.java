package cz.uhk.raidplanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CharacterOnEvent {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="mycharacter_id")
	private MyCharacter myCharacter;
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MyCharacter getMyCharacter() {
		return myCharacter;
	}
	public void setMyCharacter(MyCharacter myCharacter) {
		this.myCharacter = myCharacter;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String role;
	private String status;
}
