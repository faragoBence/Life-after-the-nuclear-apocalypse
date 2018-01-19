package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Outpost {
    Survivor[] survivors;
    Items[] inventory;
    private static Scanner scanner = new Scanner(System.in);

    public Outpost(Survivor[] survivors, Items[] inventory) {
        this.survivors = survivors;
        this.inventory = inventory;
    }

    public Outpost(String survivorsPath, String[] paths) throws FileNotFoundException {
        this.survivors = SurvivorReading(survivorsPath);
        this.inventory = ItemReading(paths);
    }

    static Outpost createNewOutpost() throws FileNotFoundException {
        String[] paths = new String[] { "../data/foods.csv", "../data/medicines.csv", "../data/weapons.csv" };
        return new Outpost("../data/survivors.csv", paths);

    }
    static Outpost loadOutpost() throws FileNotFoundException {
        String[] paths = new String[] { "../data/savedfoods.csv", "../data/savedmedicines.csv", "../data/savedweapons.csv" };
        return new Outpost("../data/savedsurvivors.csv", paths);
    }

    public int lineCounter(String CSVPath) {
        int cnt = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVPath))) {
            while ((reader.readLine()) != null) {
                cnt++;
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cnt;
    }
    //Create the Survivors and items for file reading.

    public Survivor createSurvivor(String[] attrib) {
        return new Survivor(attrib[0], Integer.parseInt(attrib[1]), Integer.parseInt(attrib[2]),
                Integer.parseInt(attrib[3]), Integer.parseInt(attrib[4]), Integer.parseInt(attrib[5]), attrib[6]);
    }

    public Food createFood(String[] attrib) {
        return new Food(attrib[0], Integer.parseInt(attrib[1]), Integer.parseInt(attrib[2]));
    }

    public Medicine createMedicine(String[] attrib) {
        return new Medicine(attrib[0], Integer.parseInt(attrib[1]), Integer.parseInt(attrib[2]));
    }

    public Weapon createWeapon(String[] attrib) {
        return new Weapon(attrib[0], Integer.parseInt(attrib[1]), Integer.parseInt(attrib[2]));
    }

    //Reads the datas from file

    public Survivor[] SurvivorReading(String CSVPath) throws FileNotFoundException {
        int numOFLines = lineCounter(CSVPath);
        int lineNumber = 0;
        String line = "";
        Survivor[] survivors = new Survivor[numOFLines];
        try (BufferedReader survivorReader = new BufferedReader(new FileReader(CSVPath))) {
            while ((line = survivorReader.readLine()) != null) {
                String[] attributes = line.split(",");
                survivors[lineNumber] = createSurvivor(attributes);
                lineNumber++;
            }
            survivorReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return survivors;
    }

    public Items[] ItemReading(String[] path) throws FileNotFoundException {
        int numOFLines = 0;
        for (String csv : path) {
            numOFLines += lineCounter(csv);
        }
        Items[] items = new Items[numOFLines];
        int lineNumber = 0;
        String line;
        for (String csv : path) {
            line = "";
            try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
                while ((line = reader.readLine()) != null) {
                    String[] attributes = line.split(",");
                    if (csv.equals(path[0])) {
                        items[lineNumber] = createFood(attributes);
                    } else if (csv.equals(path[1])) {
                        items[lineNumber] = createMedicine(attributes);
                    } else {
                        items[lineNumber] = createWeapon(attributes);
                    }

                    lineNumber++;
                }
                reader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return items;
    }

    //Add items to the specific arrays.

    public void addTo(Items item) {
        Items[] tempArray = new Items[inventory.length + 1];
        for (int i = 0; i < inventory.length; i++) {
            tempArray[i] = inventory[i];
        }
        tempArray[tempArray.length - 1] = item;
        inventory = tempArray;
        System.out.println("\n" + item.getName() + " added to your inventory");
    }

    public void addTo(Survivor survivor) {
        Survivor[] tempArray = new Survivor[survivors.length + 1];
        for (int i = 0; i < survivors.length; i++) {
            tempArray[i] = survivors[i];
        }
        tempArray[tempArray.length - 1] = survivor;
        survivors = tempArray;
        System.out.println("\n" + survivor.getName() + " joined to your outpost");
    }

    public Survivor findSurvivor(String name) {
        for (Survivor survivor : survivors) {
            if (survivor.getName().equals(name)) {
                return survivor;
            }
        }
        return null;
    }

    public Food findFood(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(name) && inventory[i] instanceof Food) {
                return (Food) inventory[i];
            }
        }
        return null;
    }

    public Weapon findWeapon(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(name) && inventory[i] instanceof Weapon) {
                return (Weapon) inventory[i];
            }
        }
        return null;
    }

    public Medicine findMedicine(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(name) && inventory[i] instanceof Medicine) {
                return (Medicine) inventory[i];
            }
        }
        return null;
    }

    public void List(String type) {
        if (type.equals("Survivor")) {
            for (int i = 0; i < survivors.length; i++) {
                System.out.println(survivors[i].getName());
            }
        } else if (type.equals("Inventory")) {
            for (int i = 0; i < inventory.length; i++) {
                inventory[i].getName();
            }
        } else if (type.equals("Weapon")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Weapon) {
                    ((Weapon) inventory[i]).printAttributes();
                }
            }
        } else if (type.equals("Food")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Food) {
                    ((Food) inventory[i]).printAttributes();
                }
            }
        } else if (type.equals("Medicine")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Medicine) {
                    ((Medicine) inventory[i]).printAttributes();
                }
            }
        } else {
            System.out.println("\nWrong input, enter something from the list below");
            System.out.println("\nSurvivor, Inventory, Weapon, Food, Medicine");
        }
    }

    public void removeItem(String name) {
        int cnt = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(name)) {
                Items[] copy = new Items[inventory.length - 1];
                System.arraycopy(inventory, 0, copy, 0, i);
                System.arraycopy(inventory, i + 1, copy, i, inventory.length - i - 1);
                inventory = copy;
                cnt++;
                System.out.println("\n" + name + "removed from your inventory");
            }
        }
        if (cnt == 0) {
            System.out.println("\nNo such element in the inventory");
        }
    }

    public void printMenu() {
        System.out.println("\nWhat's your next move?\n");
        System.out.println("\t:create = create new Survivor");
        System.out.println("\t:list = List your inventory");
        System.out.println("\t:eat = Consume a food");
        System.out.println("\t:heal = Use a medicine to heal your wounds");
        System.out.println("\t:rest = Action points go to max and you go to the next day");
        System.out.println("\t:save = Save the game");
        System.out.println("\t:exit = Quit from the game.");

    }

    public void destinationList() {
        for (Places places : Places.values()) {
            System.out.println("\t" + places + "\n");
        }

    }

    public void travel(Survivor survivor) {
        Places places = Places.OUTPOST;
        while (true) {
            destinationList();
            System.out.println("\nWhere do you want to travel");
            String destination = scanner.next().toUpperCase();
            if (destination.equals("0")) {
                break;
            } else if (destination.equals(survivor.getCurrentLocation().toUpperCase())) {
                System.out.println("\nYou are already here -_-");
                break;
            }
            try {
                places = Places.valueOf(destination);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println("\nYou entered wrong destination, pls enter a valid one or enter 0 to stay here!");
            }

        }
        switch (places) {
        case OUTPOST:
            survivor.setCurrentLocation("Outpost");
            break;
        case GASSTATION:
            survivor.setCurrentLocation("GasStation");
            break;
        case HOSPITAL:
            survivor.setCurrentLocation("Hospital");
            break;
        case MILITARYBASE:
            survivor.setCurrentLocation("MilitaryBase");
            break;
        case SCHOOL:
            survivor.setCurrentLocation("School");
            break;
        default:
            throw new IllegalArgumentException();

        }

    }

    public String[] decompressSurvivor(Survivor survivor) {
        String attrib[] = new String[7];
        attrib[0] = survivor.getName();
        attrib[1] = Integer.toString(survivor.getActionPoints());
        attrib[2] = Integer.toString(survivor.getHungerLevel());
        attrib[3] = Integer.toString(survivor.getHealth());
        attrib[4] = Integer.toString(survivor.getRadiationLevel());
        attrib[5] = Integer.toString(survivor.getStrength());
        attrib[6] = survivor.getCurrentLocation();
        return attrib;
    }

    public String[] decompressFood(Food food) {
        String attrib[] = new String[3];
        attrib[0] = food.getName();
        attrib[1] = Integer.toString(food.getFoodValue());
        attrib[2] = Integer.toString(food.getRadiation());
        return attrib;
    }

    public String[] decompressMedicine(Medicine medicine) {
        String attrib[] = new String[3];
        attrib[0] = medicine.getName();
        attrib[1] = Integer.toString(medicine.getHealingFactor());
        attrib[2] = Integer.toString(medicine.getRadiationHealingFactor());
        return attrib;
    }

    public String[] decompressWeapon(Weapon weapon) {
        String attrib[] = new String[3];
        attrib[0] = weapon.getName();
        attrib[1] = Integer.toString(weapon.getStrength());
        attrib[2] = Integer.toString(weapon.getDurabillity());
        return attrib;
    }

    public void writeToSurvivorFile() {
        String[] attributes = null;
        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter("../data/savedsurvivors.csv"));
            StringBuilder sb = new StringBuilder();
            for (Survivor survivor:survivors) {
                int collCnt=0;
                attributes = decompressSurvivor(survivor);
                for(String att:attributes){
                    sb.append(att);
                    collCnt++;
                    if (collCnt != 7){
                        sb.append(",");
                    }
                    
                }
                    sb.append("\n");
            }
            String mystr=sb.toString();
            mystr = mystr.substring(0, mystr.length()-1);
            bw.write (mystr);
            bw.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
    }

    public void writeToItemsFile(String path, String type) {
        String[] attributes = null;
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            StringBuilder sb = new StringBuilder();
            if (type.equals("Weapon")){
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] instanceof Weapon) {
                        Weapon weapon = (Weapon) inventory[i];
                        int collCnt=0;
                        attributes = decompressWeapon(weapon);
                        for(String att:attributes){
                            sb.append(att);
                            collCnt++;
                            if (collCnt != 3){
                                sb.append(",");
                            }
                            
                        }
                            sb.append("\n");
                    }
                }
            }
            else if (type.equals("Food")){
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] instanceof Food) {
                        Food food = (Food) inventory[i];
                        int collCnt=0;
                        attributes = decompressFood(food);
                        for(String att:attributes){
                            sb.append(att);
                            collCnt++;
                            if (collCnt != 3){
                                sb.append(",");
                            }
                            
                        }
                            sb.append("\n");
                    }
                }
            }
            else if (type.equals("Medicine")){
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] instanceof Medicine) {
                        Medicine medicine = (Medicine) inventory[i];
                        int collCnt=0;
                        attributes = decompressMedicine(medicine);
                        for(String att:attributes){
                            sb.append(att);
                            collCnt++;
                            if (collCnt != 3){
                                sb.append(",");
                            }
                            
                        }
                            sb.append("\n");
                    }
                }
            }

            String mystr=sb.toString();
            mystr = mystr.substring(0, mystr.length()-1);
            bw.write (mystr);
            bw.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
    }


}
