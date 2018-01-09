/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Item> inventoryItems = new HashMap<>();

    private static final String INVENTORY_FILE = "INVENTORY.txt";
    private static final String DELIMITER = "::";

    private void loadInventory() throws VendingMachineDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException(
                    "-_- Could not load inventory into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER, 4);

            Item currentItem = new Item(currentTokens[0]);

            currentItem.setItemName(currentTokens[1]);

            String bdString = currentTokens[2];
            BigDecimal bdPrice = new BigDecimal(bdString);
            currentItem.setPrice(bdPrice);

            String amtString = currentTokens[3];
            int amtInv = Integer.parseInt(amtString);
            currentItem.setInvAmount(amtInv);

            inventoryItems.put(currentItem.getIdOfInventory(), currentItem);

        }

        scanner.close();
    }

    private void writeInventory() throws VendingMachineDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException(
                    "Could not save student data.", e);
        }

        List<Item> itemList = this.getAllInventory();
        for (Item currentItem : itemList) {

            out.println(currentItem.getIdOfInventory() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getPrice() + DELIMITER
                    + currentItem.getInvAmount());

            out.flush();
        }

        out.close();
    }

    @Override
    public List<Item> getAllInventory() {

        return new ArrayList<Item>(inventoryItems.values());
    }

    @Override
    public Item getInventory(String idOfInventory) {

        return inventoryItems.get(idOfInventory);
    }

    @Override
    public Item removeInventory(String idOfInventory, Item item) {
        Item removedItem = inventoryItems.remove(idOfInventory);

        return removedItem;

    }

    @Override
    public Item addInventory(String idOfInventory, Item item) {
        Item newItem = inventoryItems.put(idOfInventory, item);

        return newItem;
    }

    @Override
    public void editItem(Item item) {

    }

    @Override
    public Item removeInventory(String idOfInventory) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void openDao() throws VendingMachineDaoException {
        loadInventory();

    }

    @Override
    public void closedDao() throws VendingMachineDaoException {
        writeInventory();
    }

}
