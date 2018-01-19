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

                System.out.print("You must create a Survivor first. Enter his name!\n");
                String name = scanner.next();
                mySurvivor = new Survivor(name, 2, 100, 100, 100, 5, "Outpost");
                myOutpost.addTo(mySurvivor);
                break;
            } else if (line.equals("2")) {
                myOutpost = Outpost.loadOutpost();
                myOutpost.List("Survivor");
                System.out.println("Choose a survivor from the list above!");
                String name = scanner.next();
                mySurvivor =myOutpost.findSurvivor(name);
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
                System.out.print("Enter the name of your new survivor!\n");
                String name = scanner.next();
                mySurvivor = new Survivor(name, 2, 100, 100, 100, 5, "Outpost");
                myOutpost.addTo(mySurvivor);
            } else if (menuChoose.equals(":list")) {
                System.out.println("Choose from the listing options\n");
                System.out.println("\t(1) Survivors\n\t(2) Item names\n\t(3) Foods\n\t(4) Medicines\n\t(5) Weapons");
                String listingOption = scanner.next();
                if (listingOption.equals("1")) {
                    myOutpost.List("Survivor");
                } else if (listingOption.equals("2")) {
                    myOutpost.List("Inventory");
                } else if (listingOption.equals("3")) {
                    myOutpost.List("Food");
                } else if (listingOption.equals("4")) {
                    myOutpost.List("Medicine");
                } else if (listingOption.equals("5")) {
                    myOutpost.List("Weapon");
                } else {
                    System.out.println("You entered wrong input!\n");
                }

            }

        }
    }

    //myOutpost.writeToSurvivorFile();
    //myOutpost.writeToItemsFile("../data/savedweapons.csv", "Weapon");
    //myOutpost.writeToItemsFile("../data/savedfoods.csv", "Food");
    //myOutpost.writeToItemsFile("../data/savedmedicines.csv", "Medicine");

}