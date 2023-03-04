package calculator;

public class MultiplicationImpl implements Calculate {
    @Override
    public String calculate(String x, Object y) {
        UtilHelper.checkCurrencyFormat(x);
        if (!(y instanceof Integer)) {
            throw new NumberFormatException("Multiplication second param needs to be a single number!");
        }
        var multiplyNum = Integer.parseInt(y.toString());
        var numbersX = UtilHelper.splitStringInput(x);
        return UtilHelper.convertResult(numbersX[0] * multiplyNum, numbersX[1] * multiplyNum, numbersX[2] * multiplyNum);
    }
}
