package com.odde.assertionsample;

public class Calculator {

    public double divide(double first, double second)
    {
        if (second == 0)
        {
            throw new YouShallNotPassException();
        }
        return first / second;
    }
}
