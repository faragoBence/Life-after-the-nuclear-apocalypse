package com.codecool.web.model.creatures;

import com.codecool.web.model.Entity;

public  class Creature extends Entity {

    public Creature(String name, int health, int strength,int agility) {
        super(name,health,strength,agility);
    }


    @Override
    public String toString() {
        return "\thealth = "+getHealth()+"\tstrength = "+getStrength()+"\tagility = "+getAgility()+"\n";
    }
}
