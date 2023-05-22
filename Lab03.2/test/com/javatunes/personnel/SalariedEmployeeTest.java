package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    //instance variable
    private SalariedEmployee emp;


    @Before
    public void setUp() {
        emp = new SalariedEmployee("Mary", Date.valueOf("2020-10-10"), 1500.0);

    }

//    @Test
//    public void testPay() {
//        assertEquals(1500.0, emp.pay(), .001);
//    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, emp.payTaxes(), .001);
    }
}