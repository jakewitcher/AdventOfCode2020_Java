package day2;

import java.util.Arrays;
import java.util.List;

public class SledRentalPolicy implements Policy {
    private final int min;
    private final int max;
    private final char requiredChar;

    public SledRentalPolicy(int min, int max, char requiredChar) {
        this.min = min;
        this.max = max;
        this.requiredChar = requiredChar;
    }

    @Override
    public boolean isValidPassword(String password) {
        int matchedChars = 0;
        for (var c : password.toCharArray()) {
            if (c == requiredChar) {
                matchedChars++;
            }
        }

        return matchedChars >= min && matchedChars <= max;
    }
}
