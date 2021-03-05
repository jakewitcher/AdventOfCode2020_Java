import day1.ExpenseReport;

public class Main {
    public static void main(String[] args) {
        day1Part1();
        day1Part2();
    }

    private static void day1Part1() {
        var maybeExpenses = InputReader.readAsInt("./src/main/java/day1/input.txt");
        maybeExpenses.map(ExpenseReport::new)
                .flatMap(day1 -> day1.findProductOfTwoEntriesEqualTo(2020))
                .ifPresent(System.out::println);
    }

    private static void day1Part2() {
        var maybeExpenses = InputReader.readAsInt("./src/main/java/day1/input.txt");
        maybeExpenses.map(ExpenseReport::new)
                .flatMap(day1 -> day1.findProductOfThreeEntriesEqualTo(2020))
                .ifPresent(System.out::println);
    }
}
