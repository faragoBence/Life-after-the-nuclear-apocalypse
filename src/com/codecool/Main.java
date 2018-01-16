package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Outpost myOutpost = Outpost.createOutpost();
        Survivor mySurvivor = new Survivor("Jani", 2, 100, 100, 0, 5, "Outpost");
        myOutpost.addTo(new Food("sajt", 20, 35));
        myOutpost.addTo(new Food("sajt", 20, 35));
        myOutpost.addTo(new Weapon("reszelo", 5, 2));
        myOutpost.List("Food");

        myOutpost.List("Inventory");

        myOutpost.removeItem("sajt");
        myOutpost.List("Food");
        System.out.println((myOutpost.inventory).length);
        School mySchool = School.createSchool();
        mySchool.listCreatures();
        mySchool.search(mySurvivor, myOutpost);
        myOutpost.List("Inventory");
    }
}