package com.codecool;

import java.util.Scanner;

public class Fight {

    private static Scanner scanner = new Scanner(System.in);

    static boolean fighting(Survivor survivor, Creatures enemy, Outpost outpost) {
        System.out.println("\n"+enemy.getName() + " attacked you");
        enemy.printAttributes();
        System.out.println("\nyour health: "+ survivor.getHealth() + " your strength: "+survivor.getStrength());
        boolean won;
        int yourStrength = survivor.getStrength();
        Weapon yourWeapon;
        while (true) {
            System.out.println("\nDo you want to use a weapon from your inventory? \n(Y)es or (N)o?");
            String line = scanner.next();
            if (line.equals("Y")) {
                while (true) {
                    outpost.List("Weapon");
                    System.out.println("\nEnter the name of the weapon, that you want to use");
                    line = scanner.next();
                    if (line.equals("0")){
                        break;
                    }
                    if (outpost.findWeapon(line) != null) {
                        yourWeapon = outpost.findWeapon(line);
                        yourWeapon.setDurabillity(-1);
                        yourStrength += yourWeapon.getStrength();
                        break;
                    } else {
                        System.out.println("\nEnter a weapon name from the list or enter 0 to go back");
                    }
                }
                break;
            } else if (line.equals("N")) {
                break;
            } else {
                System.out.println("\nWrong input enter Y or N");
            }
        }

        while (true) {
            enemy.setHealth(0 - yourStrength);
            if (enemy.getHealth() < 1) {
                System.out.println("\nCongratulations, you won the fight");
                System.out.println("\nyour health: "+ survivor.getHealth() + " your strength: "+survivor.getStrength());
                won = true;
                break;
            }
            survivor.setHealth(0 - enemy.getStrength());
            if (survivor.getHealth() < 1) {
                System.out.println("\nYou lost the fight, your Survivor is dead");
                won = false;
                break;
            }
        }
        survivor.setActionPoints(-1);
        return won;
    }
}