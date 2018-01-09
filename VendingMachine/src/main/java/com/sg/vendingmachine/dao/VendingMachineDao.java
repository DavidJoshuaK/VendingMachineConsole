/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

//import com.sg.vendingmachine.dto.VendingMachine;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingMachineDao {

    Item addInventory(String idOfInventory, Item item);
            //throws VendingMachineDaoException;

    List<Item> getAllInventory();
           // throws VendingMachineDaoException;

    Item getInventory(String itemName);
           // throws VendingMachineDaoException;

    Item removeInventory(String idOfInventory, Item item);
           // throws VendingMachineDaoException;

    void editItem(Item item);
           // throws VendingMachineDaoException;

    public Item removeInventory(String idOfInventory);

    public void openDao() throws VendingMachineDaoException;

    public void closedDao() throws VendingMachineDaoException;
}
