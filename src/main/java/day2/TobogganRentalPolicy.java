package day2;

public class TobogganRentalPolicy implements Policy {
    private final int first;
    private final int second;
    private final char requiredChar;

    public TobogganRentalPolicy(int first, int second, char requiredChar) {
        this.first = first - 1;
        this.second = second - 1;
        this.requiredChar = requiredChar;
    }

    @Override
    public boolean isValidPassword(String password) {
        var isMatchFirst = password.length() >= first && password.charAt(first) == requiredChar;
        var isMatchSecond = password.length() >= second && password.charAt(second) == requiredChar;

        return isMatchFirst ^ isMatchSecond;
    }
}
