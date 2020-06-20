package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartphoneTest {

    @Test
    void shouldMatchByManufacturer() {
        Smartphone smartphone = new Smartphone(3, "Iphone se", 39990, "Apple");
        boolean actual = smartphone.matches("Apple");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByManufacturer() {
        Smartphone smartphone = new Smartphone(3, "Iphone se", 39990, "Apple");
        boolean actual = smartphone.matches("Samsung");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByName() {
        Smartphone smartphone = new Smartphone(4, "Galaxy Fold", 179990, "Samsung");
        boolean actual = smartphone.matches("Galaxy Fold");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Smartphone smartphone = new Smartphone(4, "Galaxy Fold", 179990, "Samsung");
        boolean actual = smartphone.matches("S10");
        assertFalse(actual);
    }

}
