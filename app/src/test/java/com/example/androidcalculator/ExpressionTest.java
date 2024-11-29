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
        assertEquals(10,expression.calculateResult(), 0.001);

    }
    @Test
    public void subtractionTest() {
        Expression expression=new Expression();
        expression.addNumber("5");
        expression.addOperand("-");
        expression.addNumber("5");
        assertEquals(0,expression.calculateResult(), 0.001);

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
    @Test
    public void sinTest() {
        Expression expression = new Expression();
        expression.openExpression("sin(");
        expression.addNumber("30");
        expression.closeExpression();
        assertEquals(Math.sin(30), expression.calculateResult(), 0.001);
    }

    @Test
    public void cosTest() {
        Expression expression = new Expression();
        expression.openExpression("cos(");
        expression.addNumber("60");
        expression.closeExpression();
        assertEquals(Math.cos(60), expression.calculateResult(), 0.001);
    }

    @Test
    public void logTest() {
        Expression expression = new Expression();
        expression.openExpression("log(");
        expression.addNumber("100");
        expression.closeExpression();
        assertEquals(Math.log(100), expression.calculateResult(), 0.001);
    }

    @Test
    public void squareRootTest() {
        Expression expression = new Expression();
        expression.openExpression("√(");
        expression.addNumber("16");
        expression.closeExpression();
        assertEquals(Math.sqrt(16), expression.calculateResult(), 0.001);
    }
    @Test
    public void complexExpressionTest1() {
        Expression expression = new Expression();
        expression.addNumber("10");
        expression.addOperand("+");
        expression.openExpression("(");
        expression.addNumber("5");
        expression.addOperand("*");
        expression.addNumber("2");
        expression.closeExpression();
        assertEquals(10+(5*2), expression.calculateResult(), 0.001);
    }

    @Test
    public void complexExpressionTest2() {
        Expression expression = new Expression();
        expression.openExpression("sin(");
        expression.addNumber("30");
        expression.closeExpression();
        expression.addOperand("+");
        expression.openExpression("√(");
        expression.addNumber("16");
        expression.closeExpression();
        assertEquals(Math.sin(30)+Math.sqrt(16), expression.calculateResult(), 0.001);
    }
}
