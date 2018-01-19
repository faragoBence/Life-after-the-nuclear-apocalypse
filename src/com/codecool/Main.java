package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        Outpost myOutpost = Outpost.createNewOutpost();
        Survivor mySurvivor;
        School mySchool = School.createSchool();
        GasStation myGasStation = GasStation.createGasStation();
        Hospital myHospital = Hospital.createHospital();
        MilitaryBase myMilitaryBase = MilitaryBase.createMilitaryBase();

        while (true) {
            System.out.println("\t(1) New Game\n\t(2) Load Game\n\t(0) Quit Game");
            String line = scanner.next();
            if (line.equals("1")) {
                mySurvivor = myOutpost.survivorcreating();
                myOutpost.addTo(mySurvivor);
                break;
            } else if (line.equals("2")) {
                myOutpost = Outpost.loadOutpost();
                myOutpost.List("Survivor");
                System.out.println("Choose a survivor from the list above!");
                String name = scanner.next();
                mySurvivor = myOutpost.findSurvivor(name);
                break;
            } else if (line.equals("0")) {
                System.exit(0);
            } else {
                System.out.println("Enter a valid menu point!");
            }
        }
        while (true) {
            mySurvivor.printAttributes();
            myOutpost.printMenu();
            String menuChoose = scanner.next();
            if (menuChoose.equals(":create")) {
                mySurvivor = myOutpost.survivorcreating();
                myOutpost.addTo(mySurvivor);
            } else if (menuChoose.equals(":list")) {
                myOutpost.listing();
            } else if (menuChoose.equals(":eat")) {
                myOutpost.eating(mySurvivor);
            } else if (menuChoose.equals(":heal")) {
                myOutpost.healing(mySurvivor);
            } else if (menuChoose.equals(":rest")) {
                myOutpost.rest(mySurvivor);
            } else if (menuChoose.equals(":travel")) {
                myOutpost.travel(mySurvivor);
            } else if (menuChoose.equals(":save")) {
                myOutpost.saving();
            } else if (menuChoose.equals(":exit")) {
                myOutpost.quit();

            }
        }
    }
}