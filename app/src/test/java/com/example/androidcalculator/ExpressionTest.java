package com.example.androidcalculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class ExpressionTest {

    @Test
    public void additionTest() {
        Expression expression=new Expression();
        expression.addNumber("5");
        expression.addOperand("+");
        expression.addNumber("5");
        assertEquals(10,expression.calculateResult());

    }
    @Test
    public void subtractionTest() {
        Expression expression=new Expression();
        expression.addNumber("5");
        expression.addOperand("-");
        expression.addNumber("5");
        assertEquals(0,expression.calculateResult());

    }
    @Test
    public void multiplicationTest() {
        Expression expression = new Expression();
        expression.addNumber("5");
        expression.addOperand("*");
        expression.addNumber("5");
        assertEquals(25, expression.calculateResult(), 0.001);
    }

    @Test
    public void divisionTest() {
        Expression expression = new Expression();
        expression.addNumber("10");
        expression.addOperand("/");
        expression.addNumber("2");
        assertEquals(5, expression.calculateResult(), 0.001);
    }
}
