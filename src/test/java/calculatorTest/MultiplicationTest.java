package calculatorTest;

import calculator.Calculate;
import calculator.MultiplicationImpl;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicationTest {
    Calculate multiplication = new MultiplicationImpl();

    @Test
    public void multiplicationSuccessfully() {
        // given
        var x = "5p 17s 8d";
        var y = 2;

        //when
        var expected = "11p 15s 4d";
        var actual = multiplication.calculate(x, y);

        //then
        BDDAssertions.then(actual).isEqualTo(expected);
    }

    @Test
    public void multiplicationFailed_WrongFormatSent() {
        // given
        var x = "5p 17s 8d";
        var y = "3p 4s 10d";

        //when-then
        assertThrows(NumberFormatException.class, () -> multiplication.calculate(x, y));
    }
}
