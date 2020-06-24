package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    Smartphone smart = new Smartphone(1,"Nokia",1500,"Nokia");

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemove() {
        repository.save(smart);
        repository.removeById(1);
        assertNull(repository.findById(1));
    }

}