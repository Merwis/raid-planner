package cz.uhk.raidplanner.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
public class EventTemplate {

	@Id
	@GeneratedValue
	private int id;
	@Size(min=1, message="Název musí obsahovat alespoò 1 znak")
	private String name;
	@Digits(integer=2, fraction=0, message="Min. level musí být rozumné èíslo")
	private int minLvl;
	@Digits(integer=2, fraction=0, message="Poèet hráèù musí být rozumné èíslo")
	private int maxPlayers;
	private String note;
	@OneToMany(mappedBy="eventTemplate")
	private List<Event> events;
	
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMinLvl() {
		return minLvl;
	}
	public void setMinLvl(int minLvl) {
		this.minLvl = minLvl;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
