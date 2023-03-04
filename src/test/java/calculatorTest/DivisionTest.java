package calculatorTest;

import calculator.Calculate;
import calculator.DivisionImpl;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionTest {
    Calculate division = new DivisionImpl();

    @Test
    public void divisionSuccessfully_testcaseA() {
        // given
        var x = "5p 17s 8d";
        var y = 3;

        //when
        var expected = "1p 19s 2d (2d)";
        var actual = division.calculate(x, y);

        //then
        BDDAssertions.then(actual).isEqualTo(expected);
    }

    @Test
    public void divisionSuccessfully_testcaseB() {
        // given
        var x = "18p 16s 1d";
        var y = 15;

        //when
        var expected = "1p 5s 0d (1s 1d)";
        var actual = division.calculate(x, y);

        //then
        BDDAssertions.then(actual).isEqualTo(expected);
    }

    @Test
    public void divisionFailed_WrongFormatSent() {
        // given
        var x = "5p 17s 8d";
        var y = "3p 4s 10d";

        //when-then
        assertThrows(NumberFormatException.class, () -> division.calculate(x, y));
    }
}