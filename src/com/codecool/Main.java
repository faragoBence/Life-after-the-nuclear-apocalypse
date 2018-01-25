package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) throws FileNotFoundException {
        Outpost myOutpost = new Outpost(new Survivor[0] , new Items[0]);
        Survivor mySurvivor;
        School mySchool = School.createSchool();
        GasStation myGasStation = GasStation.createGasStation();
        Hospital myHospital = Hospital.createHospital();
        MilitaryBase myMilitaryBase = MilitaryBase.createMilitaryBase();

        while (true) {
            myOutpost.clearScreen();
            System.out.println("\t(1) New Game\n\t(2) Load Game\n\t(3) Story\n\t(4) Help\n\t(0) Quit Game");
            String line = scanner.nextLine();
            if (line.equals("1")) {
                myOutpost.clearScreen();
                mySurvivor = myOutpost.survivorcreating();
                myOutpost.clearScreen();
                myOutpost.addTo(mySurvivor);
                break;
            } else if (line.equals("2")) {
                myOutpost = Outpost.loadOutpost();
                myOutpost.clearScreen();
                myOutpost.List("Survivor");
                System.out.println("Choose a survivor from the list above!");
                String name = scanner.nextLine();
                myOutpost.clearScreen();
                mySurvivor = myOutpost.findSurvivor(name);
                break;
            }else if (line.equals("3")) {
                myOutpost.story();
            }else if (line.equals("4")) {
                myOutpost.help();
            } else if (line.equals("0")) {
                System.exit(0);
            } else {
                System.out.println("Enter a valid menu point!");
            }
        }
        while (true) {
            mySurvivor.printAttributes();
            myOutpost.printMenu();
            String menuChoose = scanner.nextLine();
            if (menuChoose.equals(":create")) {
                myOutpost.clearScreen();
                mySurvivor = myOutpost.survivorcreating();
                myOutpost.addTo(mySurvivor);
            } else if (menuChoose.equals(":list")) {
                myOutpost.clearScreen();
                myOutpost.listing();
            } else if (menuChoose.equals(":eat")) {
                myOutpost.clearScreen();
                myOutpost.eating(mySurvivor);
            } else if (menuChoose.equals(":heal")) {
                myOutpost.clearScreen();
                myOutpost.healing(mySurvivor);
            } else if (menuChoose.equals(":rest")) {
                myOutpost.clearScreen();
                myOutpost.rest(mySurvivor);
            } else if (menuChoose.equals(":travel")) {
                myOutpost.clearScreen();
                myOutpost.travel(mySurvivor,myGasStation,myHospital,mySchool,myMilitaryBase);
            } else if (menuChoose.equals(":search")) {
                myOutpost.clearScreen();
                switch (mySurvivor.getCurrentLocation()) {
                    case "Outpost":
                        System.out.println("You can't scarvange your outpost!");
                        break;
                    case "GasStation":
                        myGasStation.search(mySurvivor, myOutpost);
                        break;
                    case "Hospital":
                        myHospital.search(mySurvivor, myOutpost);
                        break;
                    case "MilitaryBase":
                        myMilitaryBase.search(mySurvivor, myOutpost);
                        break;
                    case "School":
                        mySchool.search(mySurvivor, myOutpost);
                        break;
                    default:
                        throw new IllegalArgumentException();
                    }
            } else if (menuChoose.equals(":help")) {
                myOutpost.clearScreen();
                myOutpost.help();
            } else if (menuChoose.equals(":look")) {
                myOutpost.clearScreen();
                myOutpost.description(mySurvivor,myGasStation, myHospital, myMilitaryBase, mySchool);
            } else if (menuChoose.equals(":save")) {
                myOutpost.clearScreen();
                myOutpost.saving();
            } else if (menuChoose.equals(":exit")) {
                myOutpost.clearScreen();
                myOutpost.quit();

            }
            else{
                myOutpost.clearScreen();
                System.out.println("You entered an unknown command!\n");
            }
        }
    }
}