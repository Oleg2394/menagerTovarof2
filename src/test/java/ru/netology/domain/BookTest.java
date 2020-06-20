package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BookTest {

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(1, "Мастер и Маргарита", 450, "Михаил Булгаков");
        boolean actual = book.matches("Михаил Булгаков");
        assertTrue(actual);

    }

    @Test
    void shouldNotMatchByAuthor() {
        Book book = new Book(1, "Мастер и Маргарита", 450, "Михаил Булгаков");
        boolean actual = book.matches("Рей Брэдбери");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByName() {
        Book book = new Book(1, "Мастер и Маргарита", 450, "Михаил Булгаков");
        boolean actual = book.matches("Мастер и Маргарита");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Book book = new Book(1, "Мастер и Маргарита", 450, "Михаил Булгаков");
        boolean actual = book.matches("451 по Фаренгейту");
        assertFalse(actual);
    }

}
