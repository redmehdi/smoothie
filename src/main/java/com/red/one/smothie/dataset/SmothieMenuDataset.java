package com.red.one.smothie.dataset;

import java.util.HashMap;
import java.util.Map;

public class SmothieMenuDataset {

    public static Map<String, String> smoothieMenu;

    public static void initial() {
        smoothieMenu = new HashMap<>();
        smoothieMenu.put("classic", "banana,honey,mango,peach,pineapple,strawberry");
        smoothieMenu.put("creezie", "blackberry,black currant,blueberry,frozen yogurt,grape juice");
        smoothieMenu.put("greenie", "apple juice,avocado,green apple,ice,lime,spinach");
        smoothieMenu.put("just desserts", "banana,cherry,chocolate,ice cream,peanut");
    }


    public static String getIngredientBySmoothieType(final String order) {
        final String menu = smoothieMenu.get(order.toLowerCase());
        if (menu == null) {
            throw new IllegalArgumentException("The smoothie that is not present in the menu");
        }
        return menu;
    }
}
