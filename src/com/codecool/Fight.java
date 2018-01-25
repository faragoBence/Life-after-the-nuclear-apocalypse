package com.codecool;

import java.util.Scanner;

public class Fight {

    private static Scanner scanner = new Scanner(System.in);

    static boolean fighting(Survivor survivor, Creatures enemy, Outpost outpost) {
        outpost.clearScreen();
        System.out.println("\n"+enemy.getName() + " attacked you");
        enemy.printAttributes();
        System.out.println("\tyour health: "+ survivor.getHealth() + "\t your strength: "+survivor.getStrength());
        boolean won;
        int yourStrength = survivor.getStrength();
        Weapon yourWeapon;
        Weapon tempWeapon;
        int enemyHealth = enemy.getHealth();
        while (true) {
            System.out.println("\nDo you want to use a weapon from your inventory? \n(Y)es or (N)o?");
            String line = scanner.nextLine();
            if (line.equals("Y")) {
                while (true) {
                    outpost.clearScreen();
                    outpost.List("Weapon");
                    System.out.println("\nEnter the name of the weapon, that you want to use");
                    line = scanner.nextLine();
                    if (line.equals("0")){
                        break;
                    }
                    if (outpost.findWeapon(line) != null) {
                        tempWeapon = outpost.findWeapon(line);
                        yourWeapon = new Weapon(tempWeapon.getName(), tempWeapon.getStrength(), tempWeapon.getDurabillity());
                        yourWeapon.setDurabillity(-1,outpost);
                        outpost.removeItem(tempWeapon.getName());
                        outpost.addTo(yourWeapon);
                        yourStrength += yourWeapon.getStrength();
                        outpost.clearScreen();
                        break;
                    } else {
                        System.out.println("\nEnter a weapon name from the list or enter 0 to go back");
                    }
                }
                break;
            } else if (line.equals("N")) {
                outpost.clearScreen();
                break;
            } else {
                System.out.println("\nWrong input enter Y or N");
            }
        }

        while (true) {
            enemyHealth-=yourStrength;
            if (enemyHealth < 1) {
                outpost.clearScreen();
                System.out.println("\nCongratulations, you won the fight");
                won = true;
                break;
            }
            survivor.setHealth(0 - enemy.getStrength());
            if (survivor.getHealth() < 1) {
                outpost.clearScreen();
                System.out.println("\nYou lost the fight, your Survivor is dead");
                won = false;
                break;
            }
        }
        survivor.setActionPoints(-1);
        survivor.setHungerLevel(-10);
        return won;
    }
}