package day1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ExpenseReportTests {
    private final List<Integer> testInput = Arrays.asList(1721, 979, 366, 299, 675, 1456);

    @Test
    public void findProductOfTwoEntriesEqualTo_TestInputWithTargetOf2020_ProductFound() {
        var expenseReport = new ExpenseReport(testInput);
        var product = expenseReport.findProductOfTwoEntriesEqualTo(2020);

        assertEquals(Optional.of(514579), product);
    }

    @Test
    public void findProductOfThreeEntriesEqualTo_TestInputWithTargetOf2020_ProductFound() {
        var expenseReport = new ExpenseReport(testInput);
        var product = expenseReport.findProductOfThreeEntriesEqualTo(2020);

        assertEquals(Optional.of(241861950), product);
    }
}
