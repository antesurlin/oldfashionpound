package calculator;

public class SumImpl implements Calculate{
    @Override
    public String calculate(String x, Object y) {
        UtilHelper.checkCurrencyFormat(x);
        UtilHelper.checkCurrencyFormat(y.toString());
        var numbersX = UtilHelper.splitStringInput(x);
        var numbersY = UtilHelper.splitStringInput(y.toString());
        return UtilHelper.convertResult(numbersX[0] + numbersY[0], numbersX[1] + numbersY[1], numbersX[2] + numbersY[2]);
    }
}
