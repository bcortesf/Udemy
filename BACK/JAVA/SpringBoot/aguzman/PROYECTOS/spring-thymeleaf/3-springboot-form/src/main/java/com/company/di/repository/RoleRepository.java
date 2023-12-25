package com.company.di.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.di.domainEntityPojo.Role;

@Repository
public class RoleRepository {
	private List<Role> roles;

	public RoleRepository() {
		this.roles = Arrays.asList(
				new Role(1, "ROLE_ADMIN", "Administrador") ,
				new Role(2, "ROLE_USER", "Usuario"),
				new Role(3, "ROLE_MODERATOR", "Moderador")
		);
	}

	public List<Role> getRoles() {
		return roles;
	}
	
}
