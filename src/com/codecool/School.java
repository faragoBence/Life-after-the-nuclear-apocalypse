package com.codecool;

public class School extends Location {

    public School(int radiationLevel, Items[] lootable, Creatures[] enemies) {
        super(radiationLevel, lootable, enemies);
    }

    static Items[] createLootableList() {
        Medicine firstAidKit = new Medicine("first aid kit", 80, 50);
        Medicine radX = new Medicine("rad-x", 25, 60);
        Food apple = new Food("apple", 10, -2);
        Food corn = new Food("corn", 15, -5);
        Food langos = new Food("langos", 25, -10);
        Food chili = new Food("chili", 50, -20);
        Weapon knife = new Weapon("knife", 10, 3);
        Weapon chainsaw = new Weapon("chainsaw", 20, 5);

        return new Items[] { firstAidKit, radX, apple, corn, langos, chili, knife, chainsaw };

    }

    static public Creatures[] createCreaturesList(){
        Creatures ghoul = new Creatures("ghoul", 25, 5);
        Creatures bandit = new Creatures("bandit", 25, 7);
        Creatures scarvanger = new Creatures("scarvanger", 20, 5);
        Creatures infestedHound = new Creatures("infested hound", 30, 10);
        Creatures zombie = new Creatures("zombie", 20, 7);

        return new Creatures[]{ghoul, bandit, scarvanger, infestedHound, zombie};
    }

    static School createSchool(){
        return new School(5, createLootableList(), createCreaturesList());
    }

    public void listCreatures(){
        for (Creatures creature : enemies){
            System.out.println(creature.getName());
        }
    }
}