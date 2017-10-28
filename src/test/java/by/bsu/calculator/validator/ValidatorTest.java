package by.bsu.calculator.validator;

import by.bsu.calculator.exception.ValidatorException;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    @Test
    public void isValidExpressionTest() throws ValidatorException{
        Assert.assertTrue(Validator.isValidExpression("6/0"));
    }
}
