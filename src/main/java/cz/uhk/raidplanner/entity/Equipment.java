package cz.uhk.raidplanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Equipment {
	
	@Id
	@GeneratedValue
	private int id;	
	private String head;
	private String chest;
	private String waist;
	private String hands;
	private String legs;
	private String boots;
	private String mainhand;
	private String offhand;
	@OneToOne(mappedBy="equip")
	private MyCharacter character;
	
	public MyCharacter getCharacter() {
		return character;
	}
	public void setCharacter(MyCharacter character) {
		this.character = character;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getChest() {
		return chest;
	}
	public void setChest(String chest) {
		this.chest = chest;
	}
	public String getWaist() {
		return waist;
	}
	public void setWaist(String waist) {
		this.waist = waist;
	}
	public String getHands() {
		return hands;
	}
	public void setHands(String hands) {
		this.hands = hands;
	}
	public String getLegs() {
		return legs;
	}
	public void setLegs(String legs) {
		this.legs = legs;
	}
	public String getBoots() {
		return boots;
	}
	public void setBoots(String boots) {
		this.boots = boots;
	}
	public String getMainhand() {
		return mainhand;
	}
	public void setMainhand(String mainhand) {
		this.mainhand = mainhand;
	}
	public String getOffhand() {
		return offhand;
	}
	public void setOffhand(String offhand) {
		this.offhand = offhand;
	}
	
	
	
}
