package com.myrestaurant.restaurantmanagement;
import java.util.ArrayList;

// 🎬 Big Picture:
// What this class does:
    // Stores ALL billing costs in the restaurant
    // Uses Singleton pattern (only ONE billing system)
    // Uses Eager initialization (created immediately at startup)

// Key Difference from SingletonOrders:
    // SingletonOrders = Lazy (creates when first needed)
    // SingletonBilling = Eager (creates immediately)
//--------------------------------------------------------->>>

public class SingletonBilling {

    // Rule1: Private constructorBlocks, Blocks new SingletonBilling() from outside
    private SingletonBilling() {}
    
    
    // **Difference from SingletonOrders:**
        // - SingletonOrders stores: `ArrayList<OrderDetails>` (order objects)
        // - SingletonBilling stores: `ArrayList<Double>` (just prices)
    // Stores prices in ArrayList<Double>
    private final ArrayList<Double> orderCosts = new ArrayList<>(); 

    // Functionality Methods
    public void addOrderCost(double orderCost){ // Add a price to billing list
        orderCosts.add(orderCost); // Appends to 'orderCosts' ArrayList
    }
    
    // Rule2: public static, Creat immediately
    // HERE IS THE KEY DIFFERENCE!
    // Why public here?
        // No `getInstance()` needed after this (direct access instead)
        // Direct access: SingletonBilling.instance
        // Safe because it's static final (can't be reassigned)
    public static SingletonBilling instance = new SingletonBilling();
//--------------------------------------------------------->>>

    public void showAllOrderCosts(){ // Display all costs + calculate total
    double total = 0.0;
    System.out.println("------All Order Costs-----");
    
    if (orderCosts.isEmpty()) {
        System.out.println("    No Orders Yet");
    } else {
        int i = 1;  // ← MOVED IT OUTSIDE THE LOOP
        // Each iteration: o holds one price
        for (double o : orderCosts) { // Loop through numbers (not objects)
            // String formatting: Format number to 2 decimal places
            System.out.println("Order " + i + " : $" + String.format("%.2f", o)); 
            total = total + o; // Add current price to running total
            i++;
        }
        System.out.println("---------------------------");
        System.out.println("Total costs = $" + String.format("%.2f", total));
    }
}
}
