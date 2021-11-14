package br.com.hugoamac.catalogo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGenPassword {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
		System.out.print( bcrypt.encode("teste"));

	}

}
