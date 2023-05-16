/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {

    @BeforeClass
    public static void initializeEntireTestRun() {
        System.out.println("Initial");
    }

    @AfterClass
    public static void finalizeEntireTestRun() {
        System.out.println("Finalize");
    }

    //business objects under test AKA fixture
    private Calculator calc;

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void cleanUp() {
        System.out.println("cleanUp");
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");
        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(11));
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        assertEquals(2.5, calc.divide(5,2), 0.001); //expected, actual, delta
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

}