package br.com.hugoamac.catalogo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "usuario")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nome")
	private String name;
	
	@Column(name = "sobrenome")
	private String lastname;
	
	@Column(name = "usuario")
	private String username;

	@Column(name = "senha")
	private String password;

	@Column(name = "ativo")
	private boolean active;

	@Column(name = "papel")
	private String roles;

	@CreatedDate
	@Column(name = "criado_em")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "atualizado_em")
	private Date updatedAt;

	public User() {

	}

	

	public User(String name, String lastname, String username, String password, boolean active, String roles) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
