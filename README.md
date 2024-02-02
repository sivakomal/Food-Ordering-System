# Food Ordering System

## Overview

This Java program implements a simple Food Ordering System where users can view a menu, select food items, specify quantities, and place orders. The system also writes the orders to a file for record-keeping.

## Files

- **FoodOrderingSystem.java**: Main program file containing the implementation of the Food Ordering System.
- **FoodItem.java**: Class representing a food item with properties such as name and price.
- **menu.txt**: File containing the menu items and their prices.
- **orders.txt**: File where the placed orders are recorded.

## How to Use

1. **Compile the Code:**
   - Ensure you have Java installed on your machine.
   - Open a terminal and navigate to the directory containing the code.
   - Compile the code using the command: `javac FoodOrderingSystem.java`

2. **Run the Program:**
   - Execute the compiled program with the command: `java FoodOrderingSystem`

3. **Ordering Process:**
   - The program will display the menu, and you can enter the item number to order or type 'exit' to quit.
   - Specify the quantity for the selected item.
   - The program will calculate the total bill and display order details.
   - Orders are written to the `orders.txt` file.

4. **Menu and Orders Files:**
   - Ensure that the `menu.txt` file contains a list of food items and their prices in the format: `itemName,price`.
   - The program will create or append orders to the `orders.txt` file.

5. **Exit:**
   - Type 'exit' at any time to exit the ordering system.

## Note

- The program reads the menu from the `menu.txt` file and writes orders to the `orders.txt` file.
- The `FoodItem` class represents a food item with a name and price.
- Input validation is implemented to handle invalid item numbers or quantities.

