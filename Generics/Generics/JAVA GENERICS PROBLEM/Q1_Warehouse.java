// Q1_Warehouse.java

import java.util.ArrayList;
import java.util.List;

// Abstract base for warehouse items
abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) { this.name = name; }
    public String getName() { return name; }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) { super(name); }
}

// Generic storage class, type-safe storage
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void add(T item) { items.add(item); }
    public T get(int idx) { return items.get(idx); }
    public List<T> getAll() { return items; }
    // Wildcard method to display any warehouse items
    public static void displayAll(List<? extends WarehouseItem> items) {
        for (WarehouseItem w : items)
            System.out.println(w.getName());
    }
}

public class Q1_Warehouse {
    public static void main(String[] args) {
        Storage<Electronics> es = new Storage<>();
        es.add(new Electronics("Laptop"));
        Storage<Groceries> gs = new Storage<>();
        gs.add(new Groceries("Apple"));
        Storage<Furniture> fs = new Storage<>();
        fs.add(new Furniture("Chair"));

        Storage.displayAll(es.getAll());
        Storage.displayAll(gs.getAll());
        Storage.displayAll(fs.getAll());
    }
}
