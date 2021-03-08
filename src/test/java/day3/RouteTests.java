package day3;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RouteTests {

    private final List<String> forrestMap = Arrays.asList(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
    );

    private Route route;

    @Before
    public void initialize() {
        route = new Route(forrestMap);
    }

    @Test
    public void countTrees_SlopeOf1Down1Right_Counts2Trees() {
        var slope = new Slope(1, 1);
        var count = route.countTrees(slope);

        assertEquals(2, count);
    }

    @Test
    public void countTrees_SlopeOf1Down3Right_Counts7Trees() {
        var slope = new Slope(1, 3);
        var count = route.countTrees(slope);

        assertEquals(7, count);
    }

    @Test
    public void countTrees_SlopeOf1Down5Right_Counts3Trees() {
        var slope = new Slope(1, 5);
        var count = route.countTrees(slope);

        assertEquals(3, count);
    }

    @Test
    public void countTrees_SlopeOf1Down7Right_Counts4Trees() {
        var slope = new Slope(1, 7);
        var count = route.countTrees(slope);

        assertEquals(4, count);
    }

    @Test
    public void countTrees_SlopeOf2Down1Right_Counts2Trees() {
        var slope = new Slope(2, 1);
        var count = route.countTrees(slope);

        assertEquals(2, count);
    }
}
