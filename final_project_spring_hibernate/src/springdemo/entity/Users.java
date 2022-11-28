package springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_role")
	private boolean user_role;
	
	public Users() {};
	
	public Users(int user_id,String fullname, String username, String password, boolean user_role) {
		this.user_id = user_id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.user_role = user_role;
	}
	
	
	

	public boolean isUser_role() {
		return user_role;
	}

	public void setUser_role(boolean user_role) {
		this.user_role = user_role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getId() {
		return user_id;
	}

	public void setId(int user_id) {
		this.user_id = user_id;
	}
	
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
