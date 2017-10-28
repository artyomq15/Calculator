package by.bsu.calculator.parse;

import by.bsu.calculator.enums.SignType;
import by.bsu.calculator.exception.ValidatorException;
import by.bsu.calculator.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.bsu.calculator.constants.ExpressionConstants.*;

public class Parser {
    private static final Pattern PATTERN = Pattern.compile(EXPRESSION_PATTERN);

    public static SignType parseSign(String expression) throws ValidatorException{
        if (Validator.isValidExpression(expression)){
            Matcher matcher = PATTERN.matcher(expression);
            matcher.matches();
            String sign = matcher.group(SIGN_GROUP);
            if (sign.equals(PLUS_SIGN)){
                return SignType.PLUS;
            }
            if (sign.equals(MINUS_SIGN)){
                return SignType.MINUS;
            }
            if (sign.equals(MULTIPLICATION_SIGN)){
                return SignType.MULTIPLICATION;
            }
            if (sign.equals(DIVISION_SIGN)){
                return SignType.DIVISION;
            }
        }
        return null;
    }

    public static double[] parseValues(String expression) throws ValidatorException{
        if (Validator.isValidExpression(expression)){
            Matcher matcher = PATTERN.matcher(expression);
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
