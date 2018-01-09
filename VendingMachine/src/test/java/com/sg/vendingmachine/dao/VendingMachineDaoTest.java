/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dao.VendingMachineDao;
import java.math.BigDecimal;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoTest {

   private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

      @Before
    public void setUp() throws Exception {
        List<Item> inventoryList = dao.getAllInventory();
        for (Item item : inventoryList) {
            dao.removeInventory(item.getIdOfInventory(), item);
        }
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of addInventory method, of class VendingMachineDao.
     */
  @Test
    public void testAddGetInventory() throws Exception {
        Item item = new Item("A2");
        item.setItemName("Cherries");
        item.setPrice(new BigDecimal("10"));
        item.setInvAmount(4);

        dao.addInventory(item.getIdOfInventory(), item);

        Item fromDAO = dao.getInventory(item.getIdOfInventory());

        assertEquals(item, fromDAO);
    }

    /**
     * Test of getAllInventory method, of class VendingMachineDao.
     */
    
    /**
     * Test of getInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetInventory() throws Exception {
        Item item = new Item("A5");
        item.setItemName("coke");
        item.setPrice(new BigDecimal("4"));
        item.setInvAmount(4);

        assertNotNull(item);
    }
    
   @Test
    public void testGetAllInventory() throws Exception {
        Item item = new Item("A2");
        item.setItemName("Cherries");
        item.setPrice(new BigDecimal("10"));
        item.setInvAmount(4);

        dao.addInventory(item.getIdOfInventory(), item);

        Item item2 = new Item("B3");
        item2.setItemName("Almonds");
        item2.setPrice(new BigDecimal("3"));
        item2.setInvAmount(6);

        dao.addInventory(item2.getIdOfInventory(), item2);

        assertEquals(2, dao.getAllInventory().size());
    }

    /**
     * Test of getInventory method, of class VendingMachineDao.
     */
//  //  @Test
//    public void testGetInventory() throws Exception {
//    }
    /**
     * Test of removeInventory method, of class VendingMachineDao.
     */
   @Test
    public void testRemoveInventory() throws Exception {
//
        Item item = new Item("A2");
        item.setItemName("Cherries");
        item.setPrice(new BigDecimal("10"));
        item.setInvAmount(4);

        dao.addInventory(item.getIdOfInventory(), item);

        Item item2 = new Item("B3");
        item2.setItemName("Almonds");
        item2.setPrice(new BigDecimal("3"));
        item2.setInvAmount(6);

        dao.addInventory(item2.getIdOfInventory(), item2);

        dao.removeInventory(item.getIdOfInventory(), item);

        assertEquals(1, dao.getAllInventory().size());
        assertNull(dao.getInventory(item.getIdOfInventory()));

        dao.removeInventory(item2.getIdOfInventory(), item);

        assertEquals(0, dao.getAllInventory().size());
        assertNull(dao.getInventory(item2.getIdOfInventory()));
//
   }

    /**
     * Test of editItem method, of class VendingMachineDao.
     */
    //@Test
    public void testEditItem() throws Exception {
    }

    /**
     * Test of addInventory method, of class VendingMachineDao.
     */
    @Test
    public void testAddInventory() throws Exception {
    }

    /**
     * Test of getInventory method, of class VendingMachineDao.
     */

    @Test
    public void testRemoveInventory_String_Item() throws Exception {
    }

    /**
     * Test of removeInventory method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveInventory_String() {
    }




}
