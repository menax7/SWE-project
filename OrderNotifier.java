package com.myrestaurant.restaurantmanagement;

import java.util.ArrayList;
import java.util.List;

// 🎬 Big Picture:
// What this class does:
    // Manages observer notifications (Student 2's pattern)
    // Uses Singleton pattern (only ONE notifier)
    // Uses Eager initialization (like SingletonBilling)

// Why you need to know this:
    // YOU explain the Singleton aspect
    // Student 2 explains the Observer aspect
    // It's a HYBRID - two patterns in one class!
//--------------------------------------------------------->>>

public class OrderNotifier {

    private static final List<OrderObserver> observers = new ArrayList<>();
    
    // What final means here:
        // The instance variable can NEVER be reassigned
        // Extra layer of protection
        // Result: Double protection!
    public static final OrderNotifier instance = new OrderNotifier(); // The Instance (Eager + Final)

    // final prevents reassigning the instance variable
    // private constructor prevents new instances
    
    private OrderNotifier() {} // Blocks new OrderNotifier() from outside

    public void addObserver(OrderObserver o) {
        if (!observers.contains(o)) { // تمنع التكرار
            observers.add(o);
        }
    }

    public void removeObserver(OrderObserver o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {
        for (OrderObserver o : observers) {
            o.update(message);
        }
    }
}

// I DON'T need to explain this code in detail!
// Just know:
// Stores a list of observers (Chef and Client)
// Can add/remove observers
// Can notify all observers at once
// Student 2 handles the Observer pattern explanation
