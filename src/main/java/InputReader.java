import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InputReader {
    public static Optional<List<Integer>> readAsInt(String path) {
        try {
            var reader = new BufferedReader(new FileReader(path));
            var expenses = new ArrayList<Integer>();

            while (reader.ready()) {
                var line = reader.readLine();
                var expense = Integer.parseInt(line);
                expenses.add(expense);
            }

            reader.close();
            return Optional.of(expenses);

        } catch (IOException e) {
            System.out.printf("failed reading file at %s%n", path);
            e.printStackTrace();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
