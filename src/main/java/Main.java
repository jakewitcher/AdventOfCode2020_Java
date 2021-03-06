import day1.ExpenseReport;
import day2.Passwords;
import input.InputReader;

public class Main {
    public static void main(String[] args) {
        day2Part1();
        day2Part2();
    }

    private static void day1Part1() {
        var maybeExpenses = InputReader.readAsInts("./src/main/java/day1/input.txt");
        maybeExpenses.map(ExpenseReport::new)
                .flatMap(day1 -> day1.findProductOfTwoEntriesEqualTo(2020))
                .ifPresent(System.out::println);
    }

    private static void day1Part2() {
        var maybeExpenses = InputReader.readAsInts("./src/main/java/day1/input.txt");
        maybeExpenses.map(ExpenseReport::new)
                .flatMap(day1 -> day1.findProductOfThreeEntriesEqualTo(2020))
                .ifPresent(System.out::println);
    }

    private static void day2Part1() {
        var maybePoliciesAndPasswords = InputReader.readAsStrings("./src/main/java/day2/input.txt");
        maybePoliciesAndPasswords.map(Passwords::new).ifPresent(passwords ->
                System.out.println(passwords.countValidBySledRentalPolicy()));
    }

    private static void day2Part2() {
        var maybePoliciesAndPasswords = InputReader.readAsStrings("./src/main/java/day2/input.txt");
        maybePoliciesAndPasswords.map(Passwords::new).ifPresent(passwords ->
                System.out.println(passwords.countValidByTobogganRentalPolicy()));
    }
}
