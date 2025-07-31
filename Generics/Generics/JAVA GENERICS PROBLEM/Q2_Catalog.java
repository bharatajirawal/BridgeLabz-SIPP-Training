// Q2_Catalog.java

import java.util.ArrayList;
import java.util.List;

// Category marker interfaces
interface BookCategory {}
interface ClothingCategory {}
interface GadgetCategory {}

// Product class restricted to category type
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public T getCategory() { return category; }
}

// Generic method to apply discount
class Catalog {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100.0);
        product.setPrice(newPrice);
    }
}

public class Q2_Catalog {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Basics", 500, new BookCategory() {});
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 400, new ClothingCategory() {});
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);

        Catalog.applyDiscount(book, 10.0);
        System.out.println(book.getName() + ": ₹" + book.getPrice());
        Catalog.applyDiscount(shirt, 20.0);
        System.out.println(shirt.getName() + ": ₹" + shirt.getPrice());
    }
}
