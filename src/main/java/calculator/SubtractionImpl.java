package calculator;

public class SubtractionImpl implements Calculate{
    @Override
    public String calculate(String x, Object y) {
        UtilHelper.checkCurrencyFormat(x);
        UtilHelper.checkCurrencyFormat(y.toString());
        var numbersX = UtilHelper.splitStringInput(x);
        var numbersY = UtilHelper.splitStringInput(y.toString());
        return UtilHelper.convertResult(0, 0,
                UtilHelper.getTotalPences(numbersX[0], numbersX[1], numbersX[2]) -
                        UtilHelper.getTotalPences(numbersY[0], numbersY[1], numbersY[2]));
    }
}
