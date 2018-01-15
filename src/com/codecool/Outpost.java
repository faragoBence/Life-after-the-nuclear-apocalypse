package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Outpost {
    Survivor[] survivors;
    Items[] inventory;

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
                Integer.parseInt(attrib[3]), Integer.parseInt(attrib[4]), attrib[5]);
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
    }

    public void addTo(Survivor survivor) {
        Survivor[] tempArray = new Survivor[survivors.length + 1];
        for (int i = 0; i < survivors.length; i++) {
            tempArray[i] = survivors[i];
        }
        tempArray[tempArray.length - 1] = survivor;
        survivors = tempArray;
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

    public void List(String type) {
        if (type.equals("Survivor")) {
            for (int i = 0; i < survivors.length; i++) {
                System.out.println(survivors[i].getName());
            }
        } else {
            for (int i = 0; i < inventory.length; i++) {
                System.out.println(inventory[i].getName());
            }
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
            }
        }
        if (cnt == 0) {
            System.out.println("No such element in the inventory");
        }
    }

}
