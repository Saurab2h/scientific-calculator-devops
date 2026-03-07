package com.calculator;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator c = new Calculator();

    @Test
    public void testSqrt() {
        assertEquals(4.0, c.sqrt(16), 0.001);
    }

    @Test
    public void testFactorial() {
        assertEquals(BigInteger.valueOf(120), Calculator.factorial(5));
    }

    @Test
    public void testLog() {
        assertEquals(Math.log(10), c.log(10), 0.001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, c.power(2,3), 0.001);
    }
}
