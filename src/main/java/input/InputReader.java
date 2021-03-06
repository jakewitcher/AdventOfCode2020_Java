package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InputReader {
    public static Optional<List<Integer>> readAsInts(String path) {
        return readAs(InputReader::asInteger, path);
    }

    public static Optional<List<String>> readAsStrings(String path) {
        return readAs(InputReader::asString, path);
    }

    public static <T> Optional<List<T>> readAs(InputModifier<T> modifier, String path) {
        try {
            var reader = new BufferedReader(new FileReader(path));
            var arrayList = new ArrayList<T>();

            while (reader.ready()) {
                var element = modifier.modify(reader.readLine());
                arrayList.add(element);
            }

            reader.close();
            return Optional.of(arrayList);

        } catch (IOException e) {
            System.out.printf("failed reading file at %s%n", path);
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private static int asInteger(String str) {
        return Integer.parseInt(str);
    }

    private static String asString(String str) {
        return str;
    }
}
