package by.bsu.calculator.parse;

import by.bsu.calculator.enums.Sign;
import by.bsu.calculator.exception.ValidatorException;
import by.bsu.calculator.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.bsu.calculator.constants.ExpressionConstants.*;

public class Parser {
    private static final Pattern pattern = Pattern.compile(EXPRESSION_PATTERN);

    public static Sign parseSign(String expression) throws ValidatorException{
        if (Validator.isValidExpression(expression)){
            Matcher matcher = pattern.matcher(expression);
            matcher.matches();
            String sign = matcher.group(SIGN_GROUP);
            if (sign.equals(PLUS_SIGN)){
                return Sign.PLUS;
            }
            if (sign.equals(MINUS_SIGN)){
                return Sign.MINUS;
            }
            if (sign.equals(MULTIPLICATION_SIGN)){
                return Sign.MULTIPLICATION;
            }
            if (sign.equals(DIVISION_SIGN)){
                return Sign.DIVISION;
            }
        }
        return null;
    }

    public static double[] parseValues(String expression) throws ValidatorException{
        if (Validator.isValidExpression(expression)){
            Matcher matcher = pattern.matcher(expression);
            matcher.matches();
            double[] values = new double[2];
            if (matcher.group(FIRST_VALUE_WITH_SIGN_GROUP).startsWith("-")){
                values[FIRST_VALUE_INDEX] = -1 * Double.parseDouble(matcher.group(FIRST_VALUE_WITHOUT_SIGN_GROUP));
            } else {
                values[FIRST_VALUE_INDEX] = Double.parseDouble(matcher.group(FIRST_VALUE_WITHOUT_SIGN_GROUP));
            }

            if (matcher.group(SECOND_VALUE_WITH_SIGN_GROUP).startsWith("-")){
                values[SECOND_VALUE_INDEX] = -1 * Double.parseDouble(matcher.group(SECOND_VALUE_WITHOUT_SIGN_GROUP));
            } else {
                values[SECOND_VALUE_INDEX] = Double.parseDouble(matcher.group(SECOND_VALUE_WITHOUT_SIGN_GROUP));
            }
            return values;

        }
        return null;
    }
}
