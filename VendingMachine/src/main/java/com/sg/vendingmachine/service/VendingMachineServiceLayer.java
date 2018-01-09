/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingMachineServiceLayer {

    public void createItem(Item item) throws VendingMachineOutOfInventoryException,
            VendingMachineValidationException,
            VendingMachineDaoException;

    List<Item> getAllInventory() throws VendingMachineDaoException;

    Item getInventory(String idOfInventory);

    Item editItem(Item item);

    Change provideChangeForItemChoice(BigDecimal userCashEntered, Item item) throws VendingMachineOutOfInventoryException,
            VendingMachineInsufficientFundsException;

    public void openDao() throws VendingMachineDaoException;

    public void closedDao() throws VendingMachineDaoException;

}
