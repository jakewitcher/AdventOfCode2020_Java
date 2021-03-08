package day3;

import java.util.List;

public class Route {
    private final List<String> forrestMap;

    public Route(List<String> forrestMap) {
        this.forrestMap = forrestMap;
    }

    public int countTrees(Slope slope) {
        var treeCount = 0;

        for (var i = 0; i < forrestMap.size(); i++) {
            if (i % slope.down != 0) {
                continue;
            }

            var multiplier = i / slope.down + 1;

            var position = new Position(
                    getRow(i, slope.down),
                    getColumn(slope.right, multiplier, forrestMap.get(i).length())
            );

            var c = getCharAt(position);
            if (c != null && isTree(c)) {
                treeCount++;
            }
        }

        return treeCount;
    }

    private Character getCharAt(Position position) {
        if (position.row >= forrestMap.size()) {
            return null;
        }

        return forrestMap.get(position.row).charAt(position.column);
    }

    private static int getRow(int start, int step) {
        return start + step;
    }

    private static int getColumn(int step, int multiplier, int width) {
        return step * multiplier % width;
    }

    private static boolean isTree(char c) {
        return c == '#';
    }
}
