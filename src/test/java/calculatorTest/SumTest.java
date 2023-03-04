package calculatorTest;

import calculator.Calculate;
import calculator.SumImpl;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SumTest {
    Calculate sum = new SumImpl();

    @Test
    public void sumSuccessfully() {
        // given
        var x = "5p 17s 8d";
        var y = "3p 4s 10d";

        //when
        var expected = "9p 2s 6d";
        var actual = sum.calculate(x, y);

        //then
        BDDAssertions.then(actual).isEqualTo(expected);
    }

    @Test
    public void sumFailed_WrongFormatSent() {
        // given
        var x = "5p 17s 8d";
        var y = "3pp 4ss 10d123";

        //when-then
        assertThrows(NumberFormatException.class, () -> sum.calculate(x, y));
    }

    @Test
    public void sumFailed_FormatNotSentAsCurrency() {
        // given
        var x = "5p 17s 8d";
        var y = 3;

        //when-then
        assertThrows(NumberFormatException.class, () -> sum.calculate(x, y));
    }
}
