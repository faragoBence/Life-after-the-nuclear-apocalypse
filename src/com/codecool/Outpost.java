package com.codecool;

public class Outpost {
    Survivor[] survivors;
    Food[] foods;
    Medicine[] medicines;
    Weapon[] weapons;

    public Outpost(Survivor[] survivors, Food[] foods, Medicine[] medicines, Weapon[] weapons) {
        this.survivors = survivors;
        this.foods = foods;
        this.medicines = medicines;
        this.weapons = weapons;
    }

    public Outpost(String survivorsPath, String foodsPath, String medicinesPath, String weaponsPath)
            throws FileNotFoundException {
        this.survivors = SurvivorReading(survivorsPath);
        this.foods = FoodReading(foodsPath);
        this.medicines = MedicineReading(medicinesPath);
        this.weapons = WeaponReading(weaponsPath);
    }

    static Outpost createOutpost() {
        return Outpost("../data/survivors.csv", "../data/foods.csv", "../data/medicines.csv", "../data/weapons.csv");

    }

    public int lineCounter(String CSVPath) {
        int cnt = 0;
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVPath))) {
            while ((line = reader.readLine()) != null) {
                cnt++;
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cnt;

    }

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

    public Food[] FoodReading(String CSVPath) throws FileNotFoundException {
        int numOFLines = lineCounter(CSVPath);
        int lineNumber = 0;
        String line = "";
        Food[] foods = new Food[numOFLines];
        try (BufferedReader foodReader = new BufferedReader(new FileReader(CSVPath))) {
            while ((line = foodReader.readLine()) != null) {
                String[] attributes = line.split(",");
                foods[lineNumber] = createFood(attributes);
                lineNumber++;
            }
            foodReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return foods;
    }

    public Medicine[] MedicineReading(String CSVPath) throws FileNotFoundException {
        int numOFLines = lineCounter(CSVPath);
        int lineNumber = 0;
        String line = "";
        Medicine[] medicines = new Medicine[numOFLines];
        try (BufferedReader medicineReader = new BufferedReader(new FileReader(CSVPath))) {
            while ((line = medicineReader.readLine()) != null) {
                String[] attributes = line.split(",");
                medicines[lineNumber] = createMedicine(attributes);
                lineNumber++;
            }
            medicineReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return medicines;
    }

    public Weapon[] WeaponReading(String CSVPath) throws FileNotFoundException {
        int numOFLines = lineCounter(CSVPath);
        int lineNumber = 0;
        String line = "";
        Weapon[] weapons = new Weapon[numOFLines];
        try (BufferedReader weaponReader = new BufferedReader(new FileReader(CSVPath))) {
            while ((line = weaponReader.readLine()) != null) {
                String[] attributes = line.split(",");
                weapons[lineNumber] = createWeapon(attributes);
                lineNumber++;
            }
            weaponReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return weapons;
    }

    public void addTo(Food food) {
        Food[] tempArray = new Food[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            tempArray[i] = foods[i];
        }
        tempArray[tempArray.length - 1] = food;
        foods = tempArray;
    }

    public void addTo(Medicine medicine) {
        Medicine[] tempArray = new Medicine[medicines.length + 1];
        for (int i = 0; i < medicines.length; i++) {
            tempArray[i] = medicines[i];
        }
        tempArray[tempArray.length - 1] = medicine;
        medicines = tempArray;
    }

    public void addTo(Weapon weapon) {
        Weapon[] tempArray = new Weapon[weapons.length + 1];
        for (int i = 0; i < weapons.length; i++) {
            tempArray[i] = weapons[i];
        }
        tempArray[tempArray.length - 1] = weapon;
        weapons = tempArray;
    }

    public void addTo(Survivor survivor) {
        Survivor[] tempArray = Survivor[survivors.length + 1];
        for (int i = 0; i < survivors.length; i++) {
            tempArray[i] = survivors[i];
        }
        tempArray[tempArray.length - 1] = survivor;
        characters = tempArray;
    }

    public Survivor find(String name) {
        for (Survivor survivor : survivors) {
            if (survivor.getName().equals(name)) {
                return character;
            }
        }
        return null;
    }

}
