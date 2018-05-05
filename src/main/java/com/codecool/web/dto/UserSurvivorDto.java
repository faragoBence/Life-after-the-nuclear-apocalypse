package com.codecool.web.dto;

import com.codecool.web.model.User;
import com.codecool.web.model.survivors.Survivor;

public class UserSurvivorDto {
    private final User user;
    private final Survivor survivor;

    public UserSurvivorDto(User user, Survivor survivor) {
        this.user = user;
        this.survivor = survivor;
    }

    public User getUser() {
        return user;
    }

    public Survivor getSurvivor() {
        return survivor;
    }
}
