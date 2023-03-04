package calculator;

public class DivisionImpl implements Calculate {
    @Override
    public String calculate(String x, Object y) {
        UtilHelper.checkCurrencyFormat(x);
        if (!(y instanceof Integer)) {
            throw new NumberFormatException("Division second param needs to be a single number!");
        }
        var divideNum = Integer.parseInt(y.toString());
        var numbersX = UtilHelper.splitStringInput(x);
        var allPence = UtilHelper.getTotalPences(numbersX[0], numbersX[1], numbersX[2]);
        var divisionResult = allPence / divideNum;
        var reminder = allPence - divisionResult * divideNum;
        return UtilHelper.convertDivisionResult(divisionResult, reminder);
    }
}
