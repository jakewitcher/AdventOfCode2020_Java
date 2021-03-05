package day1;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ExpenseReport {
    private final HashMap<Integer, Integer> expenses;
    
    public ExpenseReport(List<Integer> expenses) {
        this.expenses = toMap(expenses);
    }

    public Optional<Integer> findProductOfTwoEntriesEqualTo(int target) {
        for (var expense : expenses.keySet()) {
            var diff = target - expense;

            if (expenses.containsKey(diff) && areDistinct(expense, diff)) {
                return Optional.of(diff * expense);
            }
        }

        return Optional.empty();
    }

    public Optional<Integer> findProductOfThreeEntriesEqualTo(int target) {
        for (var outerExpense : expenses.keySet()) {
            for (var innerExpense : expenses.keySet()) {
                var diff = target - outerExpense - innerExpense;

                if (expenses.containsKey(diff) && areDistinct(outerExpense, innerExpense, diff)) {
                    return Optional.of(outerExpense * innerExpense * diff);
                }
            }
        }

        return Optional.empty();
    }

    private boolean areDistinct(int expense, int diff) {
        return diff != expense || expenses.get(expense) > 1;
    }

    private boolean areDistinct(int outerExpense, int innerExpense, int diff) {
        if (outerExpense == innerExpense && innerExpense == diff) {
            return expenses.get(diff) > 2;
        }

        if (outerExpense == innerExpense || outerExpense == diff) {
            return expenses.get(outerExpense) > 1;
        }

        if (innerExpense == diff) {
            return expenses.get(innerExpense) > 1;
        }

        return true;
    }
    
    private static HashMap<Integer, Integer> toMap(List<Integer> expenses) {
        var expensesMap = new HashMap<Integer, Integer>();

        for (var expense : expenses) {
            expensesMap.merge(expense, 1, Integer::sum);
        }

        return expensesMap;
    }
}
