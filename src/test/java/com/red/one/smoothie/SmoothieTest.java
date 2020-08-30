package com.red.one.smoothie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SmoothieTest {

    @Test
    public void classicSmoothie() {
        assertEquals("Order Classic smoothie", "banana,honey,mango,peach,pineapple,strawberry",
                Smothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothie_withoutStrawberry_shouldExpectedResult() {
        assertEquals("banana,honey,mango,peach,pineapple",
                Smothie.ingredients("Classic,-strawberry"));
    }

    @Test
    public void classicSmoothie_withoutSomeIngredients_shouldExpectedResult() {
        assertEquals("honey,peach,pineapple,strawberry",
                Smothie.ingredients("Classic,-banana,-mango,-peanut"));
    }

    @Test
    public void dessertsSmoothie_allIngredients_shouldExpectedResult() {
        assertEquals("banana,cherry,chocolate,ice cream,peanut",
                Smothie.ingredients("Just Desserts"));
    }

    @Test
    public void dessertsSmoothie_withoutIceCreamAndPeanut_shouldExpectedResult() {
        assertEquals("banana,cherry,chocolate",
                Smothie.ingredients("Just Desserts,-ice cream,-peanut"));
    }

    @Test
    public void classicSmoothieWithoutIngredients() {
        assertEquals("",
                Smothie.ingredients("Just Desserts,-banana,-ice cream,-chocolate,-peanut,-cherry"));
    }
}