package com.company.di.service;

import java.util.List;
import java.util.Optional;

import com.company.di.domainEntityPojo.Role;

public interface IRoleService {
	public List<Role> allRoles();
	public Optional<Role> findById(Integer idRole);
}
