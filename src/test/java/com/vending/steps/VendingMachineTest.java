package com.vending.steps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class VendingMachineTest {

    @Test
    @Step("accept coins")
    public void acceptCoins() {
        VendingExample VM = new VendingExample();
        int balance=0;
        assertEquals(1,VM.drop("PENNY",balance));
        assertEquals(10,VM.drop("NICKEL",balance+5));
        assertEquals(25,VM.drop("DIME",balance+10+5));
        assertEquals(60,VM.drop("QUARTER",balance+25+10));
    }

    @Test
    public void selectProductsIfWeHaveSufficientBalance() {
        VendingExample VM = new VendingExample();
        int balance=120;
        assertEquals("You have selected COKE",VM.selectProduct("COKE",balance));
        assertEquals("You have selected PEPSI",VM.selectProduct("PEPSI",balance));
        assertEquals("You have selected SODA",VM.selectProduct("SODA",balance));
    }

    @Test
    public void selectProductsWithInSufficientBalance() {
        VendingExample VM = new VendingExample();
        int balance=10;
        assertEquals("Insert more coins",VM.selectProduct("COKE",balance));
        assertEquals("Insert more coins",VM.selectProduct("PEPSI",balance));
        assertEquals("Insert more coins",VM.selectProduct("SODA",balance));
    }

    @Test
    public void selectProductsAndReturnBalance() {
        VendingExample VM = new VendingExample();
        int balance=120;
        assertEquals("You have selected COKE and balance is 95",VM.selectProductWithBalance("COKE",balance));
        assertEquals("You have selected PEPSI and balance is 85",VM.selectProductWithBalance("PEPSI",balance));
        assertEquals("You have selected SODA and balance is 75",VM.selectProductWithBalance("SODA",balance));
    }

    @Test
    public void selectWrongProductsAndReturnBalance() {
        VendingExample VM = new VendingExample();
        int balance=120;
        assertEquals("Wrong choice: Your balance is 120",VM.selectProductWithBalance("TEST",balance));

    }

    @Test
    public void returnBalance() {
        VendingExample VM = new VendingExample();
        int balance=120;
        assertEquals("Your balance is 120",VM.selectProductWithBalance("RETURN",balance));
    }

}