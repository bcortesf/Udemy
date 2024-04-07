package com.company.alkosto.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.alkosto.entities.Role;
import com.company.alkosto.entities.User;
import com.company.alkosto.entities.enums.RoleEnum;
import com.company.alkosto.repositories.IRoleRepository;
import com.company.alkosto.repositories.IUserRepository;


@Service
public class UserServiceImpl implements IUserService{

    private final IUserRepository repository;
    private final IRoleRepository rolRepository;
    private final PasswordEncoder passwordEncoder; //@Bean en @Configuration<src\main\java\com\company\alkosto\security\SpringSecurityConfig.java>
    public UserServiceImpl(
            IUserRepository userRepository,
            IRoleRepository rolRepository,
            PasswordEncoder passwordEncoder)
    {
        this.repository = userRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) this.repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        /* Los usuarios tienen rol"USER", independiente si es un "admin" */
        List<Role> roles = new ArrayList();
        Optional<Role> optRoleUser = this.rolRepository.findByName(RoleEnum.ROLE_USER.name());
        optRoleUser.ifPresent( roles::add );
        if (user.isAdmin()) {
            Optional<Role> optRoleAdmin = this.rolRepository.findByName(RoleEnum.ROLE_ADMIN.name());
            optRoleAdmin.ifPresent( roles::add );
        }
        user.setRoles(roles);//-> actualiza roles en objeto

        /* Pasar la clave encriptada con BCRIPT */
        user.setPassword(  this.passwordEncoder.encode( user.getPassword() )  );


        return this.repository.save(user);
    }

}
