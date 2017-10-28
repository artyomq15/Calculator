package by.bsu.calculator;

import by.bsu.calculator.constants.ExpressionConstants;
import by.bsu.calculator.enums.Sign;
import by.bsu.calculator.exception.CalculatorException;
import by.bsu.calculator.exception.ValidatorException;
import by.bsu.calculator.parse.Parser;

public class Calculator {
    public Calculator(){

    }
    public double calculateExpression(String expression) throws CalculatorException{
        try {
            Sign sign = Parser.parseSign(expression);
            double[] values = Parser.parseValues(expression);
            double firstValue = values[ExpressionConstants.FIRST_VALUE_INDEX];
            double secondValue = values[ExpressionConstants.SECOND_VALUE_INDEX];

            switch (sign){
                case PLUS : {
                    return firstValue + secondValue;
                }
                case MINUS:{
                    return firstValue - secondValue;
                }
                case MULTIPLICATION:{
                    return firstValue * secondValue;
                }
                case DIVISION:{
                    return firstValue / secondValue;
                }
                default:{
                    throw new CalculatorException("No such function in calculator.");
                }
            }
        }catch (ValidatorException e){
            throw new CalculatorException(e.getMessage(), e);
        }
    }
}
