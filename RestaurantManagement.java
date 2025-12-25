package com.myrestaurant.restaurantmanagement;

// Both here to handle Arabic text properly (recipes are in Arabic)
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class RestaurantManagement {  // Main class of the program

    public static void main(String[] args) { // Program starts here!
        // Fixes Arabic display
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));  

        // Calls navigation method (the main menu)
        Question.staffOrClient();  // Shows "Client or Staff?"
    }
}
