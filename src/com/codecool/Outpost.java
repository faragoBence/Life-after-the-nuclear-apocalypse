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

    static Outpost createOutpost() throws FileNotFoundException {
        String[] paths = new String[] { "../data/foods.csv", "../data/medicines.csv", "../data/weapons.csv" };
        return new Outpost("../data/survivors.csv", paths);

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

    public Items findItems(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(name)) {
                return inventory[i];
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
                System.out.println(inventory[i].getName());
            }
        } else if (type.equals("Weapon")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Weapon) {
                    System.out.println(inventory[i].getName());
                }
            }
        } else if (type.equals("Food")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Food) {
                    System.out.println(inventory[i].getName());
                }
            }
        } else if (type.equals("Medicine")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Medicine) {
                    System.out.println(inventory[i].getName());
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
        System.out.println("What's your next move?");
        System.out.println(":create = create new Survivor");
        System.out.println(":list = List your inventory");
        System.out.println(":eat = Consume a food");
        System.out.println(":heal = Use a medicine to heal your wounds");
        System.out.println(":rest = Action points go to max and you go to the next day");

    }

    public void destinationList() {
        for (Places places : Places.values()) {
            System.out.println(places);
        }

    }

    public void travel(Survivor survivor){
        Places places = Places.OUTPOST;
        while(true){
            destinationList();
            System.out.println("Where do you want to travel");
            String destination = scanner.next().toUpperCase();
            if(destination.equals("0")){
                break;
            }
            else if(destination.equals(survivor.getCurrentLocation().toUpperCase())){
                System.out.println("You are already here -_-");
                break;
            }
            try{
                places = Places.valueOf(destination);
                break;
            }catch(IllegalArgumentException iae){
                System.out.println("You entered wrong destination, pls enter a valid one or enter 0 to stay here!");
            }
            
        }
        switch (places){
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

}
