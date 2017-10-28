package by.bsu.calculator;

import by.bsu.calculator.exception.CalculatorException;
import org.junit.Assert;
import org.junit.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static jdk.nashorn.internal.objects.Global.NaN;

public class CalculatorTest {
    @Test
    public void calculateExpressionTest() throws CalculatorException{
        Assert.assertEquals(6, new Calculator().calculateExpression("7-1"),0.000001);
        Assert.assertEquals(5.6, new Calculator().calculateExpression("4.5 + 1.1"),0.000001);
        Assert.assertEquals(9, new Calculator().calculateExpression("-3*-3"),0.000001);

        Assert.assertEquals(NaN, new Calculator().calculateExpression("0/0"),0.000001);
        Assert.assertEquals(Infinity, new Calculator().calculateExpression("526 / 0.000"),0.000001);
        Assert.assertEquals(Infinity, new Calculator().calculateExpression("78/0"),0.000001);

        Assert.assertEquals(81, new Calculator().calculateExpression("9 * 9"),0.000001);
        Assert.assertEquals(32, new Calculator().calculateExpression("-3 + 35"),0.000001);
        Assert.assertEquals(9, new Calculator().calculateExpression("27/3"),0.000001);

        Assert.assertEquals(5, new Calculator().calculateExpression("7.5 - 2.5"),0.000001);
        Assert.assertEquals(66, new Calculator().calculateExpression("-11 * -6"),0.000001);
        Assert.assertEquals(-15, new Calculator().calculateExpression("45 / -3"),0.000001);
    }

    @Test(expected = CalculatorException.class)
    public void isValidExpressionTestException()throws CalculatorException{
        Assert.assertEquals(81, new Calculator().calculateExpression("9 * 9-"),0.000001);
        Assert.assertEquals(32, new Calculator().calculateExpression("-3 *+ 35"),0.000001);
        Assert.assertEquals(9, new Calculator().calculateExpression("27 ./ 3"),0.000001);

        Assert.assertEquals(5, new Calculator().calculateExpression("7.5- - 2.5"),0.000001);
        Assert.assertEquals(66, new Calculator().calculateExpression("-11.00k1 * -6"),0.000001);
        Assert.assertEquals(-15, new Calculator().calculateExpression("4-5 / -3"),0.000001);
    }


}
