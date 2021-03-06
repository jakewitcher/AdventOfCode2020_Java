package day2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PasswordsTests {
    private Passwords passwords;

    @Before
    public void initialize() {
        var input = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        passwords = new Passwords(input);
    }

    @Test
    public void countValidBySledRentalPolicy_ThreePasswordsAndPolicies_TwoAreValid() {
        var count = passwords.countValidBySledRentalPolicy();

        assertEquals(2, count);
    }

    @Test
    public void countValidByTobogganRentalPolicy_ThreePasswordsAndPolicies_TwoAreValid() {
        var count = passwords.countValidByTobogganRentalPolicy();

        assertEquals(1, count);
    }
}
