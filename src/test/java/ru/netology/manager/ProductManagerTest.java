package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;


public class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product item1 = new Book(1, "Fahrenheit 451", 500, "Ray Bradbury");
    private Product item2 = new Book(2, "The Master and Margarita", 450, "Mikhail Bulgakov");
    private Product item3 = new Smartphone(3, "SE", 39990, "Appel");


    @BeforeEach
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
    }


    @Test
    void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Ray Bradbury");
        Product[] expected = new Product[]{item1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("The Master and Margarita");
        Product[] expected = new Product[]{item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("SE");
        Product[] expected = new Product[]{item3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer () {
        Product[] actual = manager.searchBy("Appel");
        Product[] expected = new Product[]{item3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameNotExist () {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product actual = repository.findById(11);
        assertNull(actual);
    }
}
