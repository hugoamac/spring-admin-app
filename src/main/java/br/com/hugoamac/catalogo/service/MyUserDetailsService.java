package br.com.hugoamac.catalogo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.hugoamac.catalogo.entity.User;
import br.com.hugoamac.catalogo.model.MyUserDetails;
import br.com.hugoamac.catalogo.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private UserRepository repository;

	public MyUserDetailsService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = repository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Credenciais inválidas!"));
		return user.map(MyUserDetails::new).get();
	}

}
