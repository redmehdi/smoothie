package com.red.one.smoothie;

import static com.red.one.smothie.dataset.SmothieMenuDataset.*;


public class Smothie {

    public static final String EMPTY_CHAR = "";
    public static final String SEPARATOR_COMMA = ",";

    public static String ingredients(String order) {
        initial();
        if (order == null || EMPTY_CHAR.equals(order)) {
            throw new IllegalArgumentException("The input for smoothie is invalid");
        }
        final String[] orders = order.split(SEPARATOR_COMMA);
        String smoothieIngredients = getIngredientBySmoothieType(orders[0]);

        smoothieIngredients = ingredients(orders, smoothieIngredients);

        return smoothieIngredients;
    }

    private static String ingredients(final String[] orders, String smoothieIngredients) {
        for (int i = 1; i < orders.length; i++) {
            String ingredient = orders[i].toLowerCase();
            if (ingredient.contains("-")) {
                final String allergen = ingredient.substring(1);
                smoothieIngredients = smoothieIngredients
                        .replaceAll(getAllergenIngredient(allergen), EMPTY_CHAR);
            } else if (!smoothieIngredients.contains(ingredient)) {
                throw new IllegalArgumentException("The ingredient does not exist for the menu: " + smoothieIngredients);
            }
        }
        return smoothieIngredients;
    }

    private static String getAllergenIngredient(final String allergen) {
        return "/?," + allergen + "|" + allergen + "/?,|" + allergen;
    }
}
