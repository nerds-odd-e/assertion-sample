package com.odde.assertionsample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssertExceptionSample {

    @Test
    public void divide_positive()
    {
        Calculator calculator = new Calculator();
        double actual = calculator.divide(5, 2);
        assertEquals(2.5d, actual, 0.1d);
    }

    @Test
    public void divide_zero()
    {
        Calculator calculator = new Calculator();
        double actual = calculator.divide(5, 0);

        //how to assert expected exception?
    }
}
