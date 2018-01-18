package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("1.New Game\n2. Load Game");
        String line = scanner.next();
        if (line.equals("1")){
            Outpost myOutpost = Outpost.createOutpost();
            School mySchool = School.createSchool();
            GasStation myGasStation = GasStation.createGasStation();
            Hospital myHospital = Hospital.createHospital();
            MilitaryBase myMilitaryBase = MilitaryBase.createMilitaryBase();
            System.out.print("You must create a Survivor first. Enter his name!\n");
            line = scanner.next();
            Survivor mySurvivor = new Survivor(line, 2, 100, 100, 0, 5, "Outpost");
            mySurvivor.printAttributes();
            myOutpost.printMenu();
            mySchool.search(mySurvivor, myOutpost);
            myMilitaryBase.search(mySurvivor, myOutpost);
            myHospital.search(mySurvivor, myOutpost);
            myGasStation.search(mySurvivor, myOutpost);
        }
        // Need load game src-s,game saving and else if incorrect input added
    }
}