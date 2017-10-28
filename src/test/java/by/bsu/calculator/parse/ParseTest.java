package by.bsu.calculator.parse;

import by.bsu.calculator.enums.SignType;
import by.bsu.calculator.exception.ValidatorException;
import org.junit.Assert;
import org.junit.Test;

public class ParseTest {
    @Test
    public void parseSignTest() throws ValidatorException{
        Assert.assertEquals(SignType.PLUS, Parser.parseSign("6 + 9"));
        Assert.assertEquals(SignType.MINUS, Parser.parseSign(" -6 - 9"));
        Assert.assertEquals(SignType.DIVISION, Parser.parseSign("6.1 / 9"));
        Assert.assertEquals(SignType.MULTIPLICATION, Parser.parseSign("6 * -9.5"));
        Assert.assertEquals(SignType.MINUS, Parser.parseSign("0.1 - 6.9"));
        Assert.assertEquals(SignType.PLUS, Parser.parseSign("2 + -9"));
    }

    @Test
    public void parseValuesTest() throws ValidatorException{
        Assert.assertArrayEquals(new double[]{6.5,-9}, Parser.parseValues("6.5+-9"), 0.000001);
        Assert.assertArrayEquals(new double[]{0.2,333}, Parser.parseValues("0.2* 333"), 0.000001);
        Assert.assertArrayEquals(new double[]{-79,6.02}, Parser.parseValues("   -79  / 6.02"), 0.000001);
        Assert.assertArrayEquals(new double[]{5,0}, Parser.parseValues("5  - 0"), 0.000001);
        Assert.assertArrayEquals(new double[]{1,-1}, Parser.parseValues("1*-1"), 0.000001);
    }
}
