/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * European orders are taxed as follows:
 * VAT is 17% of taxable amount.
 * Luxury tax is an additional 25% on amount over $100.
 */
public class EuropeTax implements TaxCalculator {
    private static final double vatTax = 0.17;
    private static final double luxTax = 0.25;
    private static final double luxTaxThreshold = 100.0;

    @Override
    public double taxAmount(double taxable) {
        if (taxable > luxTaxThreshold){
            double vatTaxAmount = taxable* vatTax;
            double luxTaxAmount = (taxable - luxTaxThreshold) * luxTax;
            return vatTaxAmount + luxTaxAmount;
        }
        else {
            return taxable * vatTax;
        }
    }
}