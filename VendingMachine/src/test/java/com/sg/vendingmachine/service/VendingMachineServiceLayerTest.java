/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerTest {

    VendingMachineServiceLayer service;
    VendingMachineServiceLayer VendingMachineDaoStubImpl;

    public VendingMachineServiceLayerTest() {

        VendingMachineDao dao = new VendingMachineDaoStubImpl();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllInventory method, of class VendingMachineServiceLayer.
     */

    @Test
    public void testInsufficientFundsException() throws Exception {

        Item item = new Item("A5");
        item.setItemName("coke");
        item.setPrice(new BigDecimal("4"));
        item.setInvAmount(4);

        BigDecimal userCashEntered = new BigDecimal("3.00");

        boolean correctExceptionThrown = false;
        try {
            service.provideChangeForItemChoice(userCashEntered, item);
        } catch (VendingMachineInsufficientFundsException e) {
            correctExceptionThrown = true;
        }

        Assert.assertTrue("Insufficient funds exception", correctExceptionThrown);
    }

    @Test
    public void testOutOfStockException() throws Exception {

        Item item = new Item("A5");
        item.setItemName("coke");
        item.setPrice(new BigDecimal("4"));
        item.setInvAmount(0);

        BigDecimal userCashEntered = new BigDecimal("3.00");
        boolean correctOtherExceptionThrown = false;
        try {
            service.provideChangeForItemChoice(userCashEntered, item);
        } catch (VendingMachineOutOfInventoryException e) {
            correctOtherExceptionThrown = true;
        }

        Assert.assertTrue("Out of stock exception", correctOtherExceptionThrown);
    }

    @Test
    public void testExceptionNotThrown() throws Exception {
        Item item = new Item("A5");
        item.setItemName("coke");
        item.setPrice(new BigDecimal("4"));
        item.setInvAmount(5);

        BigDecimal userCashEntered = new BigDecimal("6.00");
        boolean exceptionThrown = true;

        try {
            service.provideChangeForItemChoice(userCashEntered, item);
        } catch (VendingMachineInsufficientFundsException | VendingMachineOutOfInventoryException e) {
            exceptionThrown = false;
        }

        Assert.assertTrue("Method ran with no exception", exceptionThrown);

    }

    @Test
    public void testChangeAmount() throws Exception {



        Item item = new Item("A5");
        item.setItemName("coke");
        item.setPrice(new BigDecimal("4"));
        item.setInvAmount(5);

        BigDecimal userCashEntered = new BigDecimal("6.00");

       Change change = service.provideChangeForItemChoice(userCashEntered, item);

        Assert.assertEquals(change.getOriginalChange(), (new BigDecimal("2.00")));
        Assert.assertEquals(change.getQuartersToUser(), 8);
        Assert.assertEquals(change.getDimeToUser(), 0);
        Assert.assertEquals(change.getNickelToUser(), 0);
        Assert.assertEquals(change.getPennyToUser(), 0);

    }
    
    @Test
    public void testChangeWithPenniesAmount() throws Exception {


        Item item = new Item("A5");
        item.setItemName("coke");
        item.setPrice(new BigDecimal("4.25"));
        item.setInvAmount(5);

        BigDecimal userCashEntered = new BigDecimal("6.13");

       Change change = service.provideChangeForItemChoice(userCashEntered, item);

        Assert.assertEquals(change.getOriginalChange(), (new BigDecimal("1.88")));
        Assert.assertEquals(change.getQuartersToUser(), 7);
        Assert.assertEquals(change.getDimeToUser(), 1);
        Assert.assertEquals(change.getNickelToUser(), 0);
        Assert.assertEquals(change.getPennyToUser(), 3);

    }

}
