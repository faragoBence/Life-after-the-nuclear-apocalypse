package com.codecool.web.model.creatures;

public class CreatureFactoryImpl implements CreatureFactory {

    @Override
    public Creature getCreature(String creatureName) {
        switch (creatureName) {
            case "Ghoul":
                return new Creature("Ghoul", 25, 5, 15);
            case "Bandit":
                return new Creature("Bandit", 25, 7, 12);
            case "Scarvanger":
                return new Creature("Scarvanger", 20, 5, 10);
            case "Super human":
                return new Creature("Super human", 50, 5, 8);
            case "Infested bear":
                return new Creature("Infested bear", 50, 10, 17);
            case "Zombie":
                return new Creature("Zombie", 20, 7, 5);
            case "Infested hound":
                return new Creature("Infested hound", 30, 10, 20);
            case "Our sugardaddy : George Soros":
                return new Creature("Our sugardaddy : George Soros", 50, 15, 20);
            default:
                return null;
        }
    }
}