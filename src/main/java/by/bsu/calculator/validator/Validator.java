package by.bsu.calculator.validator;

import by.bsu.calculator.constants.ExpressionConstants;
import by.bsu.calculator.exception.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidExpression(String expression) throws ValidatorException{
        Pattern pattern = Pattern.compile(ExpressionConstants.EXPRESSION_PATTERN);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.matches()){
            return true;
        } else {
            throw new ValidatorException("Not valid expression.");
        }
    }
}
