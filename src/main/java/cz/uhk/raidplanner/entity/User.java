package cz.uhk.raidplanner.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String login;
	private String name;
	private String email;
	private String password;

	@ManyToMany
	@JoinTable
	private List<Role> roles;

	@OneToMany(mappedBy="user")
	private List<MyCharacter> characters;
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<MyCharacter> getCharacters() {
		return characters;
	}

	public void setCharacters(List<MyCharacter> characters) {
		this.characters = characters;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
