package com.company.di.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.di.domainEntityPojo.Role;
import com.company.di.repository.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired private RoleRepository roleRepository;

	@Override
	public List<Role> allRoles() {
		return roleRepository.getRoles();
	}

	@Override
	public Optional<Role> findById(Integer idRole) {
		return roleRepository.getRoles().stream()
			.filter((Role r) -> r.getId() == idRole)
			.findFirst();
	}

}
