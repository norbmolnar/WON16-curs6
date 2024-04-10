public class Main {
    public static void main(String[] args) {
        // Creating 3 Person objects
        Person person1 = new Person("Alice", 30, true);
        Person person2 = new Person("Bob", 25, false);
        Person person3 = new Person("Charlie", 40, true);

        // Printing information about the Persons
        System.out.println("Persons:");
        System.out.println(person1.getName() + ", " + person1.getAge() + ", Married: " + person1.isMarried());
        System.out.println(person2.getName() + ", " + person2.getAge() + ", Married: " + person2.isMarried());
        System.out.println(person3.getName() + ", " + person3.getAge() + ", Married: " + person3.isMarried());

        // Creating 3 Product objects
        Product product1 = new Product("Phone", 999.99, 10, "Electronics");
        Product product2 = new Product("Book", 19.99, 20, "Education");
        Product product3 = new Product("Shirt", 29.99, 0, "Clothing");

        // Printing information about the Products
        System.out.println("\nProducts:");
        System.out.println("Product 1: " + product1.getName() + ", Price: $" + product1.getPrice() +
                ", Quantity: " + product1.getQuantity() + ", Category: " + product1.getCategory());
        System.out.println("Has stock: " + product1.hasStock());
        System.out.println("Is Electronics: " + product1.isCategory("Electronics"));

        System.out.println("Product 2: " + product2.getName() + ", Price: $" + product2.getPrice() +
                ", Quantity: " + product2.getQuantity() + ", Category: " + product2.getCategory());
        System.out.println("Has stock: " + product2.hasStock());
        System.out.println("Is Electronics: " + product2.isCategory("Electronics"));

        System.out.println("Product 3: " + product3.getName() + ", Price: $" + product3.getPrice() +
                ", Quantity: " + product3.getQuantity() + ", Category: " + product3.getCategory());
        System.out.println("Has stock: " + product3.hasStock());
        System.out.println("Is Electronics: " + product3.isCategory("Electronics"));

        // Creating a Bottle object
        Bottle bottle = new Bottle(500); // Total capacity of 500 units

        // Drinking from the bottle
        System.out.println("\nBottle Status:");
        System.out.println("Available Liquid: " + bottle.getAvailableLiquid());
        System.out.println("Empty Capacity: " + bottle.getEmptyCapacity());
        System.out.println("Opening the bottle: " + bottle.openBottle());
        System.out.println("Drinking 100 units: " + bottle.drinkLiquid(100));
        System.out.println("Available Liquid: " + bottle.getAvailableLiquid());
        System.out.println("Empty Capacity: " + bottle.getEmptyCapacity());
        System.out.println("Closing the bottle: " + bottle.closeBottle());
        System.out.println("Opening the bottle again: " + bottle.openBottle());
        System.out.println("Drinking 500 units: " + bottle.drinkLiquid(500)); // Not enough liquid
    }
}

class Person {
    private String name;
    private int age;
    private boolean married;

    public Person(String name, int age, boolean married) {
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public boolean hasStock() {
        return quantity > 0;
    }

    public boolean isCategory(String category) {
        return this.category.equals(category);
    }
}

class Bottle {
    private double totalCapacity;
    private double availableLiquid;
    private boolean open;

    public Bottle(double totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.availableLiquid = totalCapacity;
        this.open = false;
    }

    public boolean hasMoreLiquid() {
        return availableLiquid > 0;
    }

    public double getAvailableLiquid() {
        return availableLiquid;
    }

    public double getEmptyCapacity() {
        return totalCapacity - availableLiquid;
    }

    public String openBottle() {
        if (open) {
            return "Bottle is already open";
        } else {
            open = true;
            return "Bottle is opened";
        }
    }

    public String closeBottle() {
        if (!open) {
            return "Bottle is already closed";
        } else {
            open = false;
            return "Bottle is closed";
        }
    }

    public String drinkLiquid(double amount) {
        if (!open) {
            return "Bottle is closed. Please open before drinking.";
        } else if (availableLiquid < amount) {
            return "Not enough liquid in the bottle.";
        } else {
            availableLiquid -= amount;
            return "You drank " + amount + " units of liquid.";
        }
    }
}
