package com.codecool.web.model;

import com.codecool.web.exception.BackpackIsFullException;
import com.codecool.web.model.items.Item;

import java.util.List;

public class Backpack {
    private final int survivorId;
    int maxSlots;
    private int id;
    private List<Item> slot;


    public Backpack(int id, int survivorId, List<Item> slot, int maxSlots) {
        this.id = id;
        this.survivorId = survivorId;
        this.slot = slot;
        this.maxSlots = maxSlots;
    }


    void pickUp(Item item) throws BackpackIsFullException {
        if (slot.size() < maxSlots) {
            slot.add(item);
        } else {
            throw new BackpackIsFullException();
        }
    }

    Item findInBackPack(String name) {
        for (Item item : slot) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    void removeFromBackPack(Item item) {
        slot.remove(item);
    }


}
