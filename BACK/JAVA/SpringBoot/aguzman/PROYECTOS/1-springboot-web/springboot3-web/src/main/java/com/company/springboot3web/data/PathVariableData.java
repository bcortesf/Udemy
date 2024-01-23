package com.company.springboot3web.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.springboot3web.domain.entitys.User;

@Component
public class PathVariableData {
    private final List<User> list;

    public PathVariableData() {
        list = Arrays.asList(
            new User(1, "Minnie", "CF1", "111"),
            new User(2, "Shushi", "CF2", "222"),
            new User(3, "Aves", "CF3", "333")
        );
    }

    public List<User> getList() {
        return list;
    }
}
