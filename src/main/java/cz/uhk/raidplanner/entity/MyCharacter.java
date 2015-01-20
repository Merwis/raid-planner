package cz.uhk.raidplanner.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;


@Entity
public class MyCharacter {

	@Id
	@GeneratedValue
	private int id;
	@Size(min=1, message="Jméno postavy musí být vyplnìno")
	private String name;
	private String race;
	private String charClass;
	private String role;
	@Digits(integer=2, fraction=0, message="Level musí být rozumné èíslo")
	private String level;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne
	@JoinColumn(name="equip_id")
	private Equipment equip;
	
	@OneToMany(mappedBy="myCharacter", cascade=CascadeType.REMOVE)
	private List<CharacterOnEvent> events;
	
	
	public List<CharacterOnEvent> getEvents() {
		return events;
	}
	public void setEvents(List<CharacterOnEvent> events) {
		this.events = events;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Equipment getEquip() {
		return equip;
	}
	public void setEquip(Equipment equip) {
		this.equip = equip;
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
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getCharClass() {
		return charClass;
	}
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
