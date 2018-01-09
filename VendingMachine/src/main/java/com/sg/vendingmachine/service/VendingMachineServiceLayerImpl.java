/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineDao dao;
   

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
   
    }

    @Override
    public List<Item> getAllInventory()
            throws VendingMachineDaoException {
        return dao.getAllInventory();
    }

    @Override
    public Item getInventory(String idOfInventory)
 {
        return dao.getInventory(idOfInventory);
    }

    @Override
    public Item editItem(Item item)  {
        item.setInvAmount(item.getInvAmount() - 1);

        dao.editItem(item);
        return item;
    }

    @Override
    public Change provideChangeForItemChoice(BigDecimal userCashEntered, Item item) throws  VendingMachineInsufficientFundsException, VendingMachineOutOfInventoryException {

        int quartersToUser = 0;
        int dimesToUser = 0;
        int nickelsToUser = 0;
        int pennyToUser = 0;
        BigDecimal changeToUser;
        BigDecimal originalChange;

        originalChange = userCashEntered.subtract(item.getPrice());

        changeToUser = originalChange;

        if (item.getInvAmount() <= 0) {
            throw new VendingMachineOutOfInventoryException("Item out of stock!");
        } else {

            BigDecimal zero = new BigDecimal("0");

            if (changeToUser.compareTo(zero) == -1) {

                throw new VendingMachineInsufficientFundsException("Insufficient Funds");

            } else {

                BigDecimal quarter = new BigDecimal(".25");
                BigDecimal dime = new BigDecimal(".10");
                BigDecimal nickel = new BigDecimal(".05");
                BigDecimal penny = new BigDecimal(".01");

                quartersToUser = changeToUser.divide(quarter, 0, RoundingMode.FLOOR).intValue();
                changeToUser = changeToUser.remainder(quarter);

                dimesToUser = changeToUser.divide(dime, 0, RoundingMode.FLOOR).intValue();
                changeToUser = changeToUser.remainder(dime);

                nickelsToUser = changeToUser.divide(nickel, 0, RoundingMode.FLOOR).intValue();
                changeToUser = changeToUser.remainder(nickel);

                pennyToUser = changeToUser.divide(penny, 0, RoundingMode.FLOOR).intValue();

            }
        }
        Change change = new Change(originalChange, quartersToUser, dimesToUser, nickelsToUser, pennyToUser);
        return change;
    }


    @Override
    public void openDao() throws VendingMachineDaoException {
        dao.openDao();

    }

    @Override
    public void closedDao() throws VendingMachineDaoException {
        dao.closedDao();
    }

    @Override
    public void createItem(Item item) throws VendingMachineOutOfInventoryException, VendingMachineValidationException, VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
