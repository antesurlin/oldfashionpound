package calculatorTest;

import calculator.Calculate;
import calculator.SubtractionImpl;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubtractionTest {
    Calculate subtraction = new SubtractionImpl();

    @Test
    public void subtractionSuccessfully() {
        // given
        var x = "5p 17s 8d";
        var y = "3p 4s 10d";

        //when
        var expected = "2p 12s 10d";
        var actual = subtraction.calculate(x, y);

        //then
        BDDAssertions.then(actual).isEqualTo(expected);
    }

    @Test
    public void subtractionFailed_WrongFormatSent() {
        // given
        var x = "5p 17s 8d";
        var y = 50;

        //when-then
        assertThrows(NumberFormatException.class, () -> subtraction.calculate(x, y));
    }
}
