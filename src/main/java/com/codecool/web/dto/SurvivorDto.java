package com.codecool.web.dto;

import com.codecool.web.model.Backpack;
import com.codecool.web.model.User;
import com.codecool.web.model.locations.Outpost;
import com.codecool.web.model.survivors.Survivor;

public class SurvivorDto {
    private final User user;
    private final Survivor survivor;
    private final Outpost outpost;
    private final Backpack backpack;

    public SurvivorDto(User user, Survivor survivor, Outpost outpost, Backpack backpack) {
        this.user = user;
        this.survivor = survivor;
        this.outpost = outpost;
        this.backpack = backpack;
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

    public Backpack getBackpack() {
        return backpack;
    }
}
