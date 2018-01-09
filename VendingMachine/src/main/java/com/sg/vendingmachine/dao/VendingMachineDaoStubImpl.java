/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    List<Item> itemList = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("A5");
        onlyItem.setItemName("coke");
        onlyItem.setPrice(new BigDecimal("7"));

        itemList.add(onlyItem);

    }

    @Override
    public Item addInventory(String idOfInventory, Item item){
        if (idOfInventory.equals(onlyItem.getIdOfInventory())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllInventory()  {
        return itemList;
    }

    @Override
    public Item getInventory(String itemName) {
        if (itemName.equals(onlyItem.getIdOfInventory())) {
            return onlyItem;
        } else {
            return null;

        }
    }

    @Override
    public Item removeInventory(String idOfInventory, Item item)  {
        if (idOfInventory.equals(onlyItem.getIdOfInventory())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void editItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item removeInventory(String idOfInventory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void openDao() throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closedDao() throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
