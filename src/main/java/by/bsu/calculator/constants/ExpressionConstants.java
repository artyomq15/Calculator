package by.bsu.calculator.constants;

public final class ExpressionConstants {
    public final static String EXPRESSION_PATTERN = "^\\s*(\\-?(\\d+(\\.\\d+)?))\\s*([\\*\\+\\-\\/])\\s*(\\-?(\\d+(\\.\\d+)?))\\s*$";

    public final static int FIRST_VALUE_WITH_SIGN_GROUP = 1;
    public final static int FIRST_VALUE_WITHOUT_SIGN_GROUP = 2;
    public final static int SECOND_VALUE_WITH_SIGN_GROUP = 5;
    public final static int SECOND_VALUE_WITHOUT_SIGN_GROUP = 6;
    public final static int SIGN_GROUP = 4;

    public final static String PLUS_SIGN = "+";
    public final static String MINUS_SIGN = "-";
    public final static String MULTIPLICATION_SIGN = "*";
    public final static String DIVISION_SIGN = "/";

    public final static int FIRST_VALUE_INDEX = 0;
    public final static int SECOND_VALUE_INDEX = 1;

    private ExpressionConstants(){}
}
