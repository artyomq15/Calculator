package by.bsu.calculator.validator;

import by.bsu.calculator.exception.ValidatorException;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    @Test
    public void isValidExpressionTest() throws ValidatorException{
        Assert.assertTrue(Validator.isValidExpression("6.5 - 66"));
        Assert.assertTrue(Validator.isValidExpression("-9 + 0.1"));
        Assert.assertTrue(Validator.isValidExpression("44 / -0.0002"));
        Assert.assertTrue(Validator.isValidExpression("0.1 * -96"));
        Assert.assertTrue(Validator.isValidExpression("-0.1 + 88"));
        Assert.assertTrue(Validator.isValidExpression("0.0001 / -0.5"));
    }

    @Test(expected = ValidatorException.class)
    public void isValidExpressionTestException()throws ValidatorException{
        Assert.assertTrue(Validator.isValidExpression("2.2 ** 0.2"));
        Assert.assertTrue(Validator.isValidExpression(".2 7 12"));
        Assert.assertTrue(Validator.isValidExpression("s + 44"));
        Assert.assertTrue(Validator.isValidExpression("33 . 556"));
        Assert.assertTrue(Validator.isValidExpression("4 < 3"));
        Assert.assertTrue(Validator.isValidExpression("22g + 8df45"));
    }
}
