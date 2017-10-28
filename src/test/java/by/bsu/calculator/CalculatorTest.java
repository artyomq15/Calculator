package by.bsu.calculator;

import by.bsu.calculator.exception.CalculatorException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void calculateExpressionTest() throws CalculatorException{
        Assert.assertEquals(6, new Calculator().calculateExpression("7-1"),0.000001);


        Assert.assertEquals(5.6, new Calculator().calculateExpression("4.5 + 1.1"),0.000001);


        Assert.assertEquals(9, new Calculator().calculateExpression("-3*-3"),0.000001);
    }
}
