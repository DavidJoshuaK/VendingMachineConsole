/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Item {

    private String idOfInventory;
    private String itemName;
    private BigDecimal price;
    private int invAmount;
    private BigDecimal userCashEntered;

    public BigDecimal getUserCashEntered() {
        return userCashEntered;
    }

    public void setUserCashEntered(BigDecimal userCashEntered) {
        this.userCashEntered = userCashEntered;
    }

    public Item(String idOfInventory) {
        this.idOfInventory = idOfInventory;
    }

    public String getIdOfInventory() {
        return idOfInventory;
    }

    public void setIdOfInventory(String idOfInventory) {
        this.idOfInventory = idOfInventory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(int invAmount) {
        this.invAmount = invAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.idOfInventory);
        hash = 43 * hash + Objects.hashCode(this.itemName);
        hash = 43 * hash + Objects.hashCode(this.price);
        hash = 43 * hash + this.invAmount;
        hash = 43 * hash + Objects.hashCode(this.userCashEntered);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.invAmount != other.invAmount) {
            return false;
        }
        if (!Objects.equals(this.idOfInventory, other.idOfInventory)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.userCashEntered, other.userCashEntered)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "Id:  " + idOfInventory + "  | name: " + itemName + " | Price: " + price + " | amount: " + invAmount;
    }

 
    

}
