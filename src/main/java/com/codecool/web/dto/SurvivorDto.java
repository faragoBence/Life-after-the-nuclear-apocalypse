package com.codecool.web.dto;

import com.codecool.web.model.User;
import com.codecool.web.model.locations.Outpost;
import com.codecool.web.model.survivors.Survivor;

public class SurvivorDto {
    private final User user;
    private final Survivor survivor;
    private final Outpost outpost;

    public SurvivorDto(User user, Survivor survivor, Outpost outpost) {
        this.user = user;
        this.survivor = survivor;
        this.outpost = outpost;
    }

    public User getUser() {
        return user;
    }

    public Survivor getSurvivor() {
        return survivor;
    }

    public Outpost getOutpost() {
        return outpost;
    }
}
