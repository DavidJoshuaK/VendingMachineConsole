/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineView {

    UserIO io = new UserIOConsoleImpl();

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuandGetSelection() {
        io.print("Hello!");
        io.print("Would you like to buy something?");
        io.print("1. Select something to buy");
        io.print("2. Exit");

        return io.readInt("Please select 1 or 2.", 1, 2);
    }

    public void displayInventory(List<Item> inventoryList) {
        for (Item currentItem : inventoryList) {
            io.print("ID: " + currentItem.getIdOfInventory()
                    + " NAME: " + currentItem.getItemName()
                    + " PRICE: $" + currentItem.getPrice()
                    + " In stock: " + currentItem.getInvAmount() + " items left");
        }
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public String getCash() {
        return io.readString("Please enter cash amount: ");

    }

    public String askInventoryChoice() {
        return io.readString("Please enter the ID of your choice!");
    }

    public void displayItem(Item item) {
        if (item != null) {
            io.print("You chose: " + item.getItemName());
            io.print("");
        } else {
            io.print("No such item.");
        }

    }
    
    public void displayChange(Change change){
        io.print("Here is your change: " + change.getOriginalChange());
        io.print("Quarters: " +  change.getQuartersToUser());
        io.print("Dimes: " + change.getDimeToUser());
        io.print("Nickels: " + change.getNickelToUser());
        io.print("Pennies: " + change.getPennyToUser());
    }
    public void printReturnMoney(String change){
        io.print("Your money back is $" + change);
    }

}
