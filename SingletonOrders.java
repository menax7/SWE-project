package com.myrestaurant.restaurantmanagement;
import java.util.ArrayList; // We're importing ArrayList (dynamic list that grows/shrinks)

// 🎬 Big Picture First:
// What this class does:
    // Stores ALL orders in the restaurant (centralized list)
    // Uses Singleton pattern (only ONE list exists)
    // Uses Lazy initialization (creates instance when first needed)

// Why Singleton here?
    // Waiter, Chef, and Client all need to see THE SAME orders
    // If each had their own list → chaos (different data everywhere)
    // One shared list → everyone sees real-time updates
//--------------------------------------------------------->>>

public class SingletonOrders {  // will show all orders 

    // The Orders Storage
    // it's private - Only THIS class can access orders
    // Why:
    // Protection! No one can do singletonOrders.orders.clear() from outside
    // Forces everyone to use your methods (addOrder(), showAllOrders())
    // Encapsulation = hide data, expose controlled methods
    
    // it's final - Ensures orders always points to the same ArrayList
    // Prevents accidental reassignment bugs

    // ArrayList is (dynamic) - Grows automatically, Can add unlimited items
    // `= new ArrayList<>()`  - Creates an empty ArrayList in memory
    
    // private = Only this class can access (encapsulation)
    private final ArrayList<OrderDetails> orders = new ArrayList<>(); // will have all orders
//--------------------------------------------------------->>>
  
    // Rule1: Private constructor (blocks "new Singleton()"), Only THIS class can create instances
    private SingletonOrders() {}
    
    // Rule2: Private static instance (starts null)
    // Why is instance static? So there's only ONE copy shared by everyone
    private static SingletonOrders instance; // The only instance

    // Rule3: Public static getInstance()
    // This is a Lazy Initialization
    // Why is getInstance() static? So you can call it without creating an object first
    public static SingletonOrders getInstance() {   // getter with lazy way
        // to get instance only if needed not all time
        if (instance == null) {                     // First call?
            instance = new SingletonOrders();       // Create only when needed
        }
        return instance;                            // Return it
    }
    // First call:  instance is null → create new → return it
    // Second call: instance exists  → skip creation → return same one
//--------------------------------------------------------->>>

    public void addOrder(OrderDetails order) { // Why public: Everyone needs to add orders
        orders.add(order); // will add orders to the arrayList if user add any order
    }

    public void showAllOrders() { // Display all orders nicely formatted
    System.out.println("===== ALL ORDERS =====");
    
    if (orders.isEmpty()) { //  checks if list is empty
        System.out.println("    No Orders Yet");
    } else {
        int i = 1;
        for (OrderDetails o : orders) { // for-each loop (loops through all orders)
            System.out.println("------------------------");
            System.out.println("Order " + i + ":");  // ← Added space and colon
            System.out.println(o);
            System.out.println("Status: " + o.getStatus()); // o.getStatus() -  calls Student 3's method (returns "Preparing" or "DONE")
            i++; // increment counter for order numbers
        }
        System.out.println("========================");
    }
}
}
//--------------------------------------------------------->>>

// 1. What is Singleton?
    // A design pattern that ensures only ONE instance of a class exists in the ENTIRE program.
//--------------------------------------------------------->>>

// 2. Real-World Analogy
    // Singleton = Your class is the "president" - only one can exist.
//--------------------------------------------------------->>>

// 3. Why Use Singleton?
    // WITHOUT Singleton: different connections! Waste of resources, data conflicts
    // WITH Singleton   : 1 connection shared by everyone! Efficient, consistent
//--------------------------------------------------------->>>

// 4. The Three Rules of Singleton
    // Rule 1: Private Constructor
    // Why? Blocks new SingletonOrders() from outside → can't create multiple instances
    // Result: Only THIS class can create instances

    // Rule 2: Private Static Instance Variable
    // Why?
    // Holds THE single instance
    // static = belongs to class, not objects (shared by everyone)
    // private = no one can access it directly

    // Rule 3: Public Static getInstance() Method
    // Why?
    // The ONLY way to get the instance
    // static = can call without an object
    // Creates instance if needed, returns existing one otherwise
//--------------------------------------------------------->>>

// 5. Two Types of Singleton:
// - Lazy Initialization
    // Pros: Saves memory (only creates if used)
    // Cons: Not thread-safe

// - Eager Initialization (Alternative)
    // Pros: Thread-safe, simpler
    // Cons: Created even if never used
//--------------------------------------------------------->>>

// 6. Key Terms We Must Know
        // Instance     > An object created from a class
        // Static       > Belongs to class, not objects; shared by all
        // Private      > Only accessible inside the class
        // Lazy         > Create only when needed
        // Eager        > Create immediately
        // Thread-safe  > Works correctly with multiple threads
//--------------------------------------------------------->>>

// * Analogy:
    // final = The box stays the same
    // You can change what's INSIDE the box (add/remove orders)
    // But you can't swap the box for a different box
//--------------------------------------------------------->>>

// Key OOP Concepts:
    // Singleton Pattern (one instance)
    // Encapsulation (private data, public methods)
    // Lazy Initialization (create when needed)
    // Static vs Instance (class-level vs object-level)