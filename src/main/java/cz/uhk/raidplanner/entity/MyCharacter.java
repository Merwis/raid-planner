package cz.uhk.raidplanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class MyCharacter {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String race;
	private String charClass;
	private String role;
	private int level;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne
	@JoinColumn(name="equip_id")
	private Equipment equip;
	
	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
