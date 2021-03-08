import day1.ExpenseReport;
import day2.Passwords;
import day3.Route;
import day3.Slope;
import input.InputReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        day3Part1();
        day3Part2();
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

    private static void day3Part1() {
        var maybeForrestMap = InputReader.readAsStrings("./src/main/java/day3/input.txt");
        var slope = new Slope(1, 3);
        maybeForrestMap.map(Route::new).ifPresent(route ->
                System.out.println(route.countTrees(slope)));
    }

    private static void day3Part2() {
        var maybeForrestMap = InputReader.readAsStrings("./src/main/java/day3/input.txt");
        var slopes = Arrays.asList(
                new Slope(1, 1),
                new Slope(1, 3),
                new Slope(1, 5),
                new Slope(1, 7),
                new Slope(2, 1)
        );

        maybeForrestMap.map(Route::new).ifPresent(route -> {
            var product = slopes.stream().mapToLong(route::countTrees)
                    .reduce((a, b) -> a * b).orElseThrow();
            System.out.println(product);
        });
    }
}
