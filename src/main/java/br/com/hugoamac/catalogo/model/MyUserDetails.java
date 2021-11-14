package br.com.hugoamac.catalogo.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.hugoamac.catalogo.entity.User;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String lastname;
	private String fullname;
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(User user) {
		this.id = user.getId();
		this.fullname = user.getName();
		this.lastname = user.getLastname();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
									.map(SimpleGrantedAuthority::new)
									.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}
	
	public String getFullname() {
		return this.getName() + " " + this.getLastname();
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return active;
	}

}
