package com.codecool.web.model.items;

import java.util.List;

public interface ItemFactory {
    Item getItem(String name);
    List<Resource> createResourceList();
}
