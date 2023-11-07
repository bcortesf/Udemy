package com.company.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.springboot.entityModel.Usuario;
import com.company.springboot.repository.IUsuarioRepo;

/**
 * https://www.youtube.com/watch?v=zQjZFHo8eO4&list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl&index=12
 */

/**
 * Se ejecuta de forma automatica, porque  SPRING-SECURITY  busca quien implementa su interfaz propia de:	 SPRING-SECURITY 
 *  implements UserDetailsService.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IUsuarioRepo repo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuarioEncontrado = repo.findByNombre(username);
		if(usuarioEncontrado == null) {
			LOG.info("Usuario [" + username +"], no encontrado");
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		/*OPCION #1*/
//		List<GrantedAuthority> roles = new ArrayList<>();
//			roles.add(new SimpleGrantedAuthority("ADMIN"));
//		UserDetails userDetails = new User(usuarioEncontrado.getNombre(), usuarioEncontrado.getClave(), roles);
//		return userDetails;
		
		/*OPCION #2*/
		return User
				.withUsername(usuarioEncontrado.getNombre())
				.password(usuarioEncontrado.getClave())
				.roles("USER")
				.build();
	}

}
