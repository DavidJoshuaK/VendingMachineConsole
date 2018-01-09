/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author apprentice
 */
class VendingMachineValidationException extends Exception {

    public VendingMachineValidationException(String message) {
        super(message);
    }

    public VendingMachineValidationException(String message, Throwable cause) {
        super(message);
    }

}
