package cz.uhk.raidplanner.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import cz.uhk.raidplanner.annotation.UniqueLogin;


@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=3, message="Login mus� obsahovat alespo� 3 znaky")
	@Column(unique = true)
	@UniqueLogin(message="U�ivatel s t�mto loginem ji� existuje")
	private String login;
	private String name;
	@Size(min=1, message="Vypl�te e-mail")
	@Email(message="Vypl�te platn� e-mail")
	private String email;
	@Size(min=5, message="Heslo mus� obsahovat alespo� 5 znak�")
	private String password;
	private boolean enabled;

	@ManyToMany
	@JoinTable
	private List<Role> roles;

	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
	private List<MyCharacter> characters;
	
	@OneToMany(mappedBy="leader")
	private List<Event> eventLeader;
	
	@OneToMany(mappedBy="author", cascade=CascadeType.REMOVE)
	private List<Actuality> actualities;
	
	public List<Event> getEventLeader() {
		return eventLeader;
	}

	public void setEventLeader(List<Event> eventLeader) {
		this.eventLeader = eventLeader;
	}

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
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Actuality> getActualities() {
		return actualities;
	}

	public void setActualities(List<Actuality> actualities) {
		this.actualities = actualities;
	}
	
	
}
