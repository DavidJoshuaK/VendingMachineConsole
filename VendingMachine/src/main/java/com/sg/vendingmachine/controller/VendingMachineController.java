/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutOfInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            service.openDao();
            while (keepGoing) {
              
                listInventory();
                menuSelection = getMenuSelection();
                switch (menuSelection) {

                    case 1:
                        getItemAndReturnChange();
                        break;

                    case 2:
                        keepGoing = false;
                        break;

                    default:

                }

            }
            service.closedDao();
        } catch (VendingMachineDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuandGetSelection();
    }

    private void listInventory() throws VendingMachineDaoException {
        List<Item> itemInventory = service.getAllInventory();
        view.displayInventory(itemInventory);

    }

    private BigDecimal getItemAndReturnChange() {
        String cash = view.getCash();
        BigDecimal cashMoney = new BigDecimal(cash);
        try {

            String title = view.askInventoryChoice();
            Item item = service.getInventory(title);
            view.displayItem(item);
            Change change = service.provideChangeForItemChoice(cashMoney, item);
            service.editItem(item);
            view.displayChange(change);

        } catch (VendingMachineInsufficientFundsException | VendingMachineOutOfInventoryException e) {
            view.displayErrorMessage(e.getMessage());
            view.printReturnMoney(cash);
        }
        return cashMoney;
    }

}
