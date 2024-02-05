package com.company.manejoerror.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.company.manejoerror.exceptions.UserNotFoundException;
import com.company.manejoerror.models.domains.User;

@Service
public class UserServiceImpl implements UserService {
    private UserNotFoundException userNotFoundException;

    // src\main\java\com\company\manejoerror\configurations\UserConfiguration.java
    @Autowired
    private List<User> list;

    public UserServiceImpl(UserNotFoundException userNotFoundException) {
        this.userNotFoundException = userNotFoundException;
    }

    @Override
    public List<User> findAll() {
        return list;
    }

    @Override
    public Optional<User> findById1(Long idUser) throws UserNotFoundException {
        /*FORMA-2 : return - User*/
        User user = list.stream()
            .filter((User u) -> u.getId().equals(idUser))
            .findFirst()
            .orElseThrow(() -> {
                //->En caso de no encontrar el usuario
                userNotFoundException.setIdUser(idUser);
                userNotFoundException.setMessage("Usuario no existente  SERVICE!");
                userNotFoundException.setDateTime(LocalDateTime.now());
                userNotFoundException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                throw userNotFoundException;
            });
        return Optional.of(user);

        /*FORMA-2 : return - Optional<User>*/
        // return list.stream()
        //     .filter((User u) -> u.getId().equals(idUser))
        //     .findFirst();
    }

    /////////////////////////////
    @Override
    public User findById2(Long idUser) {
        return list.stream()
            .filter((User u) -> u.getId().equals(idUser))
            .findFirst()
            .orElse(null);
    }

}
