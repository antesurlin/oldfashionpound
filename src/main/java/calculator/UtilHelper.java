package calculator;

import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public final class UtilHelper {
    public static void checkCurrencyFormat(String currency) {
        if (!currency.matches("\\d+p\\u0020\\d+s\\u0020\\d+d")) {
            throw new NumberFormatException("Currency format needs to be: Xp Xs Xd");
        }
    }

    public static int[] splitStringInput(String currency) {
        return Arrays.stream(currency.replace(" ", "").split("p|s|d")).mapToInt(Integer::parseInt).toArray();
    }

    public static int getTotalPences(int pound, int shilling, int pence) {
        return pence + shilling * 12 + pound * 240;
    }

    public static String convertDivisionResult(int divisionResult, int reminder) {
        var totalPound = 0;
        var totalShilling = 0;

        if (divisionResult >= 240) {
            totalPound = divisionResult / 240;
            divisionResult -= divisionResult / 240 * 240;
        }

        if (divisionResult >= 12) {
            totalShilling = divisionResult / 12;
            divisionResult -= divisionResult / 12 * 12;
        }

        return convertResult(totalPound, totalShilling, divisionResult) + " " + reminderPenceConvert(reminder);
    }

    public static String convertResult(int pound, int shilling, int pence) {
        if (pence >= 240) {
            pound += pence / 240;
            pence -= pence / 240 * 240;
        }
        if (pence >= 12) {
            shilling += pence / 12;
            pence -= pence / 12 * 12;
        }
        if (shilling >= 20) {
            pound += shilling / 20;
            shilling -= shilling / 20 * 20;
        }
        return pound + "p " + shilling + "s " + pence + "d";
    }

    private static String reminderPenceConvert(int reminderPence) {
        var pound = 0;
        var shilling = 0;
        if (reminderPence >= 240) {
            pound += reminderPence / 240;
            reminderPence -= reminderPence / 240 * 240;
        }
        if (reminderPence >= 12) {
            shilling += reminderPence / 12;
            reminderPence -= reminderPence / 12 * 12;
        }
        if (shilling >= 20) {
            pound += shilling / 20;
            shilling -= shilling / 20 * 20;
        }
        String result = "";
        if (pound > 0) {
            result = reminderStringHelper(result, pound, "p");
        }
        if (shilling > 0) {
            result = reminderStringHelper(result, shilling, "s");
        }
        if (reminderPence > 0) {
            result = reminderStringHelper(result, reminderPence, "d");
        }
        if (result.isEmpty()) {
            return result;
        }
        return "(" + result + ")";
    }

    private static String reminderStringHelper(String text, int number, String currency) {
        if (text.isEmpty()) {
            return text + number + currency;
        }
        return text + " " + number + currency;
    }
}
