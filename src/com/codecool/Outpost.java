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
    Furniture[] furnituresList;

    public Outpost(Survivor[] survivors, Items[] inventory) {
        this.furnituresList = createFurnitureList();
        this.survivors = survivors;
        this.inventory = inventory;
    }

    public Outpost(String survivorsPath, String[] paths) throws FileNotFoundException {
        this.furnituresList = createFurnitureList();
        this.survivors = SurvivorReading(survivorsPath);
        this.inventory = ItemReading(paths);
    }

    public Furniture[] createFurnitureList() {
        Furniture[] furnitures = new Furniture[9];
        furnitures[0] = new Furniture("Bed", "+1 action points", new String[] { "Wood", "Wood", "Wool", "Wool" });
        furnitures[1] = new Furniture("Refrigerator", "+1 konserv after ':rest'",
                new String[] { "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal" });
        furnitures[2] = new Furniture("Weaponmaker set", "You can craft weapons here", new String[] { "Scrap metal",
                "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal" });
        furnitures[3] = new Furniture("Oven", "You can craft foods here",
                new String[] { "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal" });
        furnitures[4] = new Furniture("Chemical Set", "You can craft foods here",
                new String[] { "Scrap metal", "Scrap metal", "Scrap metal", "Chemical", "Chemical" });
        furnitures[5] = new Furniture("Pottery", "+1 apple after ':rest'", new String[] { "Wood", "Wood", "Chemical" });
        furnitures[6] = new Furniture("Gym", "+2 basic attack power",
                new String[] { "Wood", "Wood", "Wood", "Scrap metal", "Scrap metal", "Scrap metal" });
        furnitures[7] = new Furniture("Insulation", "After ':rest' the radiation damage is decreased by 15",
                new String[] { "Wood", "Wood", "Wool", "Wool", "Scrap metal", "Scrap metal" });
        furnitures[8] = new Furniture("Water Purifier", "+1 Fresh water after ':rest'",
                new String[] { "Scrap metal", "Scrap metal", "Wood", "Wood", "Chemical", "Chemical" });
        return furnitures;

    }

    static Outpost loadOutpost() throws FileNotFoundException {
        String[] paths = new String[] { "../data/savedfoods.csv", "../data/savedmedicines.csv",
                "../data/savedweapons.csv", "../data/savedresources.csv", "../data/savedfurnitures.csv" };
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

    public Resource createResource(String attrib) {
        return new Resource(attrib);
    }

    public Furniture createFurniture(String[] attrib) {
        String[] newAttrib = new String[attrib.length - 2];
        for (int i = 2; i > attrib.length; i++) {
            newAttrib[i - 1] = attrib[i];
        }
        return new Furniture(attrib[0], attrib[1], newAttrib);
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
                    if (csv.equals(path[0])) {
                        String[] attributes = line.split(",");
                        items[lineNumber] = createFood(attributes);
                    } else if (csv.equals(path[1])) {
                        String[] attributes = line.split(",");
                        items[lineNumber] = createMedicine(attributes);
                    } else if (csv.equals(path[2])) {
                        String[] attributes = line.split(",");
                        items[lineNumber] = createWeapon(attributes);
                    } else if (csv.equals(path[4])) {
                        String[] attributes = line.split(",");
                        items[lineNumber] = createFurniture(attributes);
                    } else {
                        items[lineNumber] = createResource(line);
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
        System.out.println("\n" + survivor.getName() + " joined to your outpost\n");
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

    public Resource findResource(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(name) && inventory[i] instanceof Resource) {
                return (Resource) inventory[i];
            }
        }
        return null;
    }

    public Furniture findFurniture(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(name) && inventory[i] instanceof Furniture) {
                return (Furniture) inventory[i];
            }
        }
        return null;
    }

    public Furniture findBuildable(String name) {
        for (int i = 0; i < furnituresList.length; i++) {
            if (furnituresList[i].getName().equals(name)) {
                return furnituresList[i];
            }
        }
        return null;
    }

    public void List(String type) {
        System.out.println("\t" + type + "\n");
        int cnt = 0;
        if (type.equals("Survivor")) {
            for (int i = 0; i < survivors.length; i++) {
                System.out.println(survivors[i].getName());
            }
        } else if (type.equals("Weapon")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Weapon) {
                    ((Weapon) inventory[i]).printAttributes();
                    cnt++;
                }
            }
            handleEmptyListing(cnt, type);
        } else if (type.equals("Food")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Food) {
                    ((Food) inventory[i]).printAttributes();
                    cnt++;
                }
            }
            handleEmptyListing(cnt, type);
        } else if (type.equals("Medicine")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Medicine) {
                    ((Medicine) inventory[i]).printAttributes();
                    cnt++;
                }
            }
            handleEmptyListing(cnt, type);
        } else if (type.equals("Resource")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Resource) {
                    inventory[i].printName();
                    cnt++;
                }
            }
        } else if (type.equals("Buildables")) {
            for (Furniture furniture : furnituresList) {
                furniture.printAttributes();
            }
            handleEmptyListing(cnt, type);
        } else if (type.equals("Furniture")) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Furniture) {
                    inventory[i].printName();
                    cnt++;
                }
            }
            handleEmptyListing(cnt, type);
        } else {
            System.out.println("\nWrong input, enter something from the list below");
        }
    }

    public void removeItem(String[] names) {
        int cnt = 0;
        for (String name : names) {

            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i].getName().equals(name)) {
                    Items[] copy = new Items[inventory.length - 1];
                    System.arraycopy(inventory, 0, copy, 0, i);
                    System.arraycopy(inventory, i + 1, copy, i, inventory.length - i - 1);
                    inventory = copy;
                    cnt++;
                    System.out.println("\n" + name + " removed from your inventory");
                    break;
                }
            }
        }
        if (cnt == 0) {
            System.out.println("\nNo such element in the inventory");
        }
    }

    public void printMenu() {
        System.out.println("\nWhat's your next move?\n");
        System.out.println("\t:create = create new Survivor");
        System.out.println("\t:list = list your inventory");
        System.out.println("\t:eat = Consume a food");
        System.out.println("\t:heal = Use a medicine to heal your wounds");
        System.out.println("\t:rest = Action points go to max and you go to the next day");
        System.out.println("\t:travel = Travel to a specific location");
        System.out.println("\t:search = Search for items in your current location");
        System.out.println("\t:look = Look around and get valuable informations about the place");
        System.out.println("\t:build = Build various furniture from your resources");
        System.out.println("\t:help = Provide some description about the game");
        System.out.println("\t:save = Save the game");
        System.out.println("\t:exit = Quit from the game.");

    }

    public void destinationList() {
        for (Places places : Places.values()) {
            System.out.println("\t" + places);
        }

    }

    public void travel(Survivor survivor, GasStation myGasStation, Hospital myHospital, School mySchool,
            MilitaryBase myMilitaryBase) {
        Places places = Places.OUTPOST;
        while (true) {
            destinationList();
            System.out.println("\nWhere do you want to travel");
            String destination = scanner.nextLine().toUpperCase();
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
        clearScreen();

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

    public String[] decompressResource(Resource resource) {
        String attrib[] = new String[1];
        attrib[0] = resource.getName();
        return attrib;
    }

    public String[] decompressFurniture(Furniture furniture) {
        String attrib[] = new String[furniture.getMaterialslenght() + 2];
        String[] item = furniture.getMaterials();
        attrib[0] = furniture.getName();
        attrib[1] = furniture.getEffect();
        for (int i = 2; i < furniture.getMaterialslenght()+2; i++) {
            attrib[i] = item[i-2];
        }
        return attrib;
    }

    public void writeToSurvivorFile() {
        String[] attributes = null;
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("../data/savedsurvivors.csv"));
            StringBuilder sb = new StringBuilder();
            for (Survivor survivor : survivors) {
                int collCnt = 0;
                attributes = decompressSurvivor(survivor);
                for (String att : attributes) {
                    sb.append(att);
                    collCnt++;
                    if (collCnt != 7) {
                        sb.append(",");
                    }

                }
                sb.append("\n");
            }
            String mystr = sb.toString();
            mystr = mystr.substring(0, mystr.length() - 1);
            bw.write(mystr);
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void writeToItemsFile(String path, String type) {
        String[] attributes = null;
        if (inventory.length != 0) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(path));
                StringBuilder sb = new StringBuilder();
                if (type.equals("Weapon")) {
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] instanceof Weapon) {
                            Weapon weapon = (Weapon) inventory[i];
                            int collCnt = 0;
                            attributes = decompressWeapon(weapon);
                            for (String att : attributes) {
                                sb.append(att);
                                collCnt++;
                                if (collCnt != 3) {
                                    sb.append(",");
                                }

                            }
                            sb.append("\n");
                        }
                    }
                } else if (type.equals("Food")) {
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] instanceof Food) {
                            Food food = (Food) inventory[i];
                            int collCnt = 0;
                            attributes = decompressFood(food);
                            for (String att : attributes) {
                                sb.append(att);
                                collCnt++;
                                if (collCnt != 3) {
                                    sb.append(",");
                                }

                            }
                            sb.append("\n");
                        }
                    }
                } else if (type.equals("Medicine")) {
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] instanceof Medicine) {
                            Medicine medicine = (Medicine) inventory[i];
                            int collCnt = 0;
                            attributes = decompressMedicine(medicine);
                            for (String att : attributes) {
                                sb.append(att);
                                collCnt++;
                                if (collCnt != 3) {
                                    sb.append(",");
                                }

                            }
                            sb.append("\n");
                        }
                    }
                } else if (type.equals("Resource")) {
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] instanceof Resource) {
                            Resource resource = (Resource) inventory[i];
                            attributes = decompressResource(resource);
                            for (String att : attributes) {
                                sb.append(att);
                            }
                            sb.append("\n");
                        }
                    }
                } else if (type.equals("Furniture")) {
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] instanceof Furniture) {
                            Furniture furniture = (Furniture) inventory[i];
                            int collCnt = 0;
                            attributes = decompressFurniture(furniture);
                            for (String att : attributes) {
                                sb.append(att);
                                collCnt++;
                                if (collCnt != furniture.getMaterialslenght() + 2) {
                                    sb.append(",");
                                }

                            }
                            sb.append("\n");
                        }
                    }
                }

                String mystr = sb.toString();
                if (mystr.length() != 0) {
                    mystr = mystr.substring(0, mystr.length() - 1);
                }
                bw.write(mystr);
                bw.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public Survivor survivorcreating() {
        System.out.print("Enter the name of your new survivor!\n");
        String name = scanner.nextLine();
        return new Survivor(name, 2, 100, 100, 100, 5, "Outpost");
    }

    public void listing() {
        System.out.println("Choose from the listing options\n");
        System.out.println(
                "\t(1) Survivors\n\t(2) Items\n\t(3) Foods\n\t(4) Medicines\n\t(5) Weapons\n\t(6) Resources\n\t(7) Furnitures\n\t(8) Buildables");
        String listingOption = scanner.nextLine();
        clearScreen();
        if (listingOption.equals("1")) {
            List("Survivor");
        } else if (listingOption.equals("2")) {
            List("Food");
            List("Medicine");
            List("Weapon");
            List("Resource");
        } else if (listingOption.equals("3")) {
            List("Food");
        } else if (listingOption.equals("4")) {
            List("Medicine");
        } else if (listingOption.equals("5")) {
            List("Weapon");
        } else if (listingOption.equals("6")) {
            List("Resource");
        } else if (listingOption.equals("7")) {
            List("Furniture");
        } else if (listingOption.equals("8")) {
            List("Buildables");
        } else {
            System.out.println("\nYou entered wrong input!\n");
        }
        System.out.println("\nPress a button to continue!");
        scanner.nextLine();
        clearScreen();
    }

    public void eating(Survivor survivor) {
        List("Food");
        System.out.println("\n Please choose a food, that you want to eat");
        String foodString = scanner.nextLine();
        Food myFood = findFood(foodString);
        if (myFood != null) {
            survivor.setHungerLevel(myFood.getFoodValue());
            survivor.setRadiationLevel(0 - myFood.getRadiation());
            clearScreen();
            removeItem(new String[] { myFood.getName() });
        } else {
            clearScreen();
            System.out.println("\nYou entered wrong food name!\n");
        }
    }

    public void healing(Survivor survivor) {
        List("Medicine");
        System.out.println("\n Please choose a medicine, that you want to use");
        String medicineString = scanner.nextLine();
        Medicine myMedicine = findMedicine(medicineString);
        if (myMedicine != null) {
            survivor.setHealth(myMedicine.getHealingFactor());
            survivor.setRadiationLevel(myMedicine.getRadiationHealingFactor());
            clearScreen();
            removeItem(new String[] { myMedicine.getName() });
        } else {
            clearScreen();
            System.out.println("\nYou entered wrong medicine name!\n");
        }
    }

    public void rest(Survivor survivor) {
        if (survivor.getCurrentLocation().equals("Outpost")) {
            survivor.setActionPoints(-survivor.getActionPoints()+2);
            survivor.setHungerLevel(-35);
            survivor.setRadiationLevel(-10);
        } else {
            System.out.println("\nYou need to travel back to your outpost first!\n");
        }
    }

    public void saving() {
        while (true) {
            System.out.println("\nWarning! Your previous save will be lost!\n");
            System.out.println("Do you want to continue? (Y)es or (N)o?");
            String saveoption = scanner.nextLine();
            if (saveoption.equals("Y")) {
                writeToSurvivorFile();
                writeToItemsFile("../data/savedweapons.csv", "Weapon");
                writeToItemsFile("../data/savedfoods.csv", "Food");
                writeToItemsFile("../data/savedmedicines.csv", "Medicine");
                writeToItemsFile("../data/savedresources.csv", "Resource");
                writeToItemsFile("../data/savedfurnitures.csv", "Furniture");
                break;
            } else if (saveoption.equals("N")) {
                break;
            } else {
                clearScreen();
                System.out.println("Please enter a valid input!");
            }
        }
    }

    public void build() {
        List("Buildables");
        System.out.println("\nPlease enter a the name of the furniture, that you want to build!\n");
        String furnitureName = scanner.nextLine();
        clearScreen();
        Furniture furniture = findBuildable(furnitureName);
        if (furniture != null) {
            if (containsResource(furniture.getMaterials())) {
                if (findFurniture(furniture.getName()) == null) {
                    removeItem(furniture.getMaterials());
                    addTo(furniture);
                    System.out.println("You successfully built a(n) " + furniture.getName() + "\n");
                } else {
                    System.out.println("You already built a(n) " + furniture.getName() + "\n");
                }
            } else {
                System.out.println("You don't have the specific materials to build a(n) " + furniture.getName() + "\n");
            }
        } else {
            System.out.println("You entered wrong furniture name");
        }
    }

    public void quit() {
        System.out.println("Do you want to save before quit? (Y)es or (N)o?");
        String exitoption = scanner.nextLine();
        if (exitoption.equals("Y")) {
            saving();
            System.exit(0);
        } else if (exitoption.equals("N")) {
            System.exit(0);
        } else {
            clearScreen();
            System.out.println("Please enter a valid input!");
        }
    }

    public void help() {
        System.out.println("You need to stay alive in this game, as long as you can.\n");
        System.out.println("You can go to specific locations and search there, but warning an enemy will attack you.");
        System.out.println("In combat, you can use a weapon from your inventory.");
        System.out.println(
                "Every location has a specific radiation level, so it will decrease your radiation damage if you search there.");
        System.out.println("With every search you can find an item and two resource material for crafting");
        System.out.println("With materials you can build several useful furniture and craft items");
        System.out.println("Your action points will be decreased by 1 and hunger level by 10\n");
        System.out.println("If your action points are 0, you need to rest in your outpost.");
        System.out.println(
                "Every rest will restore you action points, but also decrease your hunger level by 35 and your radiation damage by 10");
        System.out.println(
                "Your health,radiation and hunger can be restored with ':eat' and ':heal' command.These doesn't takes action points.");
        System.out.println("You can also save your progress everytime with ':save' command\n");
        System.out.println("If your hunger,health and radiation hits 0, you are dead, so be careful!");
        System.out.println("Good luck Survivor!");
        System.out.println("\nPress a button to continue!");
        scanner.nextLine();
        clearScreen();
    }

    public void story() {
        System.out
                .println("We are in 2030.The population of the world is almost 0.It seems Paks2 was a huge mistake...");
        System.out.println("The nuclear power plant is built by a famous gas man named 'Meszaros'.");
        System.out.println("He wanted to build this factory with low cost, but something happened.");
        System.out.println("The same problem like with the red mud factory.The cheap 'kozbeszerzes' isn't so good.");
        System.out.println(
                "But you never trusted in goverment's and the modern world.You started to build an atom bunker.");
        System.out.println("You gathered enough food, and reached your bunker before the catastrophe happened.\n");
        System.out.println(
                "After 5 year of hiding, you must come out from your bunker, because you consumed all of your foods.");
        System.out.println("\nPress a button to continue!");
        scanner.nextLine();
        clearScreen();
    }

    public void description(Survivor survivor, GasStation gastatition, Hospital hospital, MilitaryBase militaryBase,
            School school) {
        switch (survivor.getCurrentLocation()) {
        case "Outpost":
            System.out.println("Your Outpost seems a very warm and comfort place. A perfect location for living.");
            break;
        case "GasStation":
            gastatition.printDescription();
            break;
        case "Hospital":
            hospital.printDescription();
            break;
        case "MilitaryBase":
            militaryBase.printDescription();
            break;
        case "School":
            school.printDescription();
            break;
        default:
            throw new IllegalArgumentException();
        }
        System.out.println("\nPress a button to continue!");
        scanner.nextLine();
        clearScreen();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void handleEmptyListing(int cnt, String type) {
        if (cnt == 0) {
            System.out.println("\nNo " + type + " is in your inventory");
        }
    }

    public boolean containsResource(String[] strings) {
        Items[] tempInv = new Items[inventory.length];
        int cnt = 0;
        for (int i = 0; i < inventory.length; i++) {
            tempInv[i] = inventory[i];
        }
        for (String str : strings) {
            for (int i = 0; i < tempInv.length; i++) {
                if (tempInv[i].getName().equals(str)) {
                    cnt++;
                    Items[] copy = new Items[tempInv.length - 1];
                    System.arraycopy(tempInv, 0, copy, 0, i);
                    System.arraycopy(tempInv, i + 1, copy, i, tempInv.length - i - 1);
                    tempInv = copy;
                    break;
                }
            }
        }
        if (cnt == strings.length) {
            return true;
        }
        return false;
    }

    public boolean containsFurnitures(String str) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void bonuses(Survivor survivor) {
        if (containsFurnitures("Bed")) {
            survivor.setActionPoints(-survivor.getActionPoints()+3);
        }
        if (containsFurnitures("Refrigerator")) {
            addTo(new Food("Canned food", 35, 0));
        }
        if (containsFurnitures("Pottery")) {
            addTo(new Food("Apple", 10, -2));
        }
        if (containsFurnitures("Gym")) {
            survivor.setStrength(7);
        }
        if (containsFurnitures("Insulation")) {
            survivor.setRadiationLevel(10);
        }
        if (containsFurnitures("Water Purifier")) {
            addTo(new Food("Fresh water", 25, -5));
        }

    }

}
