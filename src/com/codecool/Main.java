package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Outpost myOutpost = Outpost.createOutpost();
        myOutpost.addTo(new Food("sajt", 20, 35));
        myOutpost.List("Kecske");
        if (myOutpost.findItems("sajt") instanceof Food) {
            System.out.println("Ja fasza");
        }
        myOutpost.removeItem("sajt");
        myOutpost.List("Kecske");
        int a = (myOutpost.inventory).length;
        System.out.println(a);
        School mySchool = School.createSchool();
        mySchool.listCreatures();
    }
}