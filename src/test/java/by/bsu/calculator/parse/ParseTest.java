package by.bsu.calculator.parse;

import by.bsu.calculator.enums.Sign;
import by.bsu.calculator.exception.ValidatorException;
import org.junit.Assert;
import org.junit.Test;

public class ParseTest {
    @Test
    public void parseSignTest() throws ValidatorException{
        Assert.assertEquals(Sign.PLUS, Parser.parseSign("6 + 9"));
    }

    @Test
    public void parseValuesTest() throws ValidatorException{
        Assert.assertArrayEquals(new double[]{6.5,-9}, Parser.parseValues("6.5+-9"), 0.000001);
    }
}
