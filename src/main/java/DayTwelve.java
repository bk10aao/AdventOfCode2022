import java.awt.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class DayTwelve {
    private static Map<Point, Integer> grid = new HashMap<>();

    public static int WIDTH, HEIGHT;
    private static List<String> input;

    private Point start, end;

    public DayTwelve(String data) {
        this.input = Arrays.asList(data.split("\n"));
        WIDTH = input.get(0).length();
        HEIGHT = input.size();
        for (int row = 0; row < input.size(); row++) {
            String s = input.get(row);
            for(int column = 0; column < s.length(); column++) {
                Point p = new Point(row, column);
                char c  = s.charAt(column);
                if(c == 'S') {
                    start = p;
                    c = 'a';
                }
                if(c == 'E') {
                    end = p;
                    c = 'z';
                }
                grid.put(new Point(row, column), c - 'a');
            }
        }
    }
    public int partOne() {
        Map<Point, Integer> shortestPath = new HashMap<>();
        List<Point> queue = new ArrayList<>(Arrays.asList(start));
        shortestPath.put(start, 0);
        return updatePartOne(shortestPath, queue);
    }

    private int updatePartOne(Map<Point, Integer> shortestPath, List<Point> queue) {
        while (queue.size() > 0) {
            Point p = queue.remove(0);
            if(p.x != 0)
                doLogic(p, new Point(p.x - 1, p.y), shortestPath, queue);
            if(p.x != HEIGHT - 1)
                doLogic(p, new Point(p.x + 1, p.y), shortestPath, queue);
            if(p.y != 0)
                doLogic(p, new Point(p.x, p.y - 1), shortestPath, queue);
            if(p.y != WIDTH - 1)
                doLogic(p, new Point(p.x , p.y + 1), shortestPath, queue);
        }
        return shortestPath.get(end);
    }

    public int partTwo() {
        Map<Point, Integer> shortestPath = new HashMap<>();
        List<Point> queue = new ArrayList<>(Arrays.asList(start));
        shortestPath.put(start, 0);
        return updatePartTwo(shortestPath, queue);
    }

    private int updatePartTwo(Map<Point, Integer> shortestPath, List<Point> queue) {
        while (queue.size() > 0) {
            Point p = queue.remove(0);
            if(p.x != 0)
                doLogicTwo(p, new Point(p.x - 1, p.y), shortestPath, queue);
            if(p.x != HEIGHT - 1)
                doLogicTwo(p, new Point(p.x + 1, p.y), shortestPath, queue);
            if(p.y != 0)
                doLogicTwo(p, new Point(p.x, p.y - 1), shortestPath, queue);
            if(p.y != WIDTH - 1)
                doLogicTwo(p, new Point(p.x , p.y + 1), shortestPath, queue);
        }
        return shortestPath.get(end);
    }

    private void doLogicTwo(Point p, Point direction, Map<Point, Integer> shortestPath, List<Point> queue) {
        int gridHeight = grid.get(direction);

        if(gridHeight - grid.get(p)  <= 1) {
            int pathLength = shortestPath.get(p);
            int path = shortestPath.getOrDefault(direction, Integer.MAX_VALUE);
            if(path > pathLength + 1) {
                queue.add(direction);
                shortestPath.put(direction, gridHeight ==  0 ? 0 : pathLength + 1);
            }
        }
    }

    private void doLogic(Point p, Point direction, Map<Point, Integer> shortestPath, List<Point> queue ) {
        int height = grid.get(p);
        int pathLength = shortestPath.get(p);
        if(grid.get(direction) - height  <= 1) {
            int upPath = shortestPath.getOrDefault(direction, Integer.MAX_VALUE);
            if(upPath > pathLength + 1) {
                queue.add(direction);
                shortestPath.put(direction, pathLength + 1);
            }
        }
    }
    public static void main(String[] args) {
        DayTwelve dayTwelve = new DayTwelve(puzzleInput);
        System.out.printf("Part one: %s\n", dayTwelve.partOne());
        System.out.printf("Part two: %s\n", dayTwelve.partTwo());
    }

    private static final String puzzleInput =   "abaaaaacccccccccccccccccccccccccccccccccccccccaaaaaaaccccaaaaaaaaaaaaaaaaacccccaaaaaacccccccccccccccccccccccaaaaaaaaccccccccccccccccccccccccccccccccaaaaaa\n" +
                                                "abaaaaaacccaaaacccccccccccccccccccccccaccccccccaaaaaaaaccaaaaaaaaaaaaaaaaccccccaaaaaacccccccccccccccccccccccccaaaaccccccccccccccccccccccccccccccccccaaaaaa\n" +
                                                "abaaaaaacccaaaacccccccccccccccccaaaaaaaacccccccaaaaaaaaacaaaaaaaaaaaaacccccccccaaaaacccccccccccccccccccccccccaaaaacccccccccccccccccccaaaccccccccccccaaaaaa\n" +
                                                "abaaacaccccaaaaccccccccccccccccccaaaaaacccccccccaaaaaaaccccaaaaaaaaaaacccccccccaaaaacccccccccccccccccccccccccaacaaaccccccccccccccccccaaacccccccccccccccaaa\n" +
                                                "abaaacccccccaaacccccccccccaacccccaaaaaaccccccccaaaaaaccccccaacaaaaaaaacccccccccccccccccccccccaaccccccccccccccacccaaaaacccccccccaaccccaaacccccccccccccccaaa\n" +
                                                "abccccccccccccccccccccccccaaaaccaaaaaaaacccccccaaaaaaaccccccccaaaaaaaaaccccccccccaacccccccccaaaccccccccccccccccccacaaacccccccccaaaaccaaacccccccccccccccaac\n" +
                                                "abccccccccccccccccccccccaaaaaacaaaaaaaaaaccccccaaccaaaaacccccaaaaccaaaaccccccccccaaacaacccccaaacaaacccaaccccccccaaaaaaaacccccccaaaaakkkkkkcccccccccccccccc\n" +
                                                "abccccccccccccccccccccccaaaaaccaaaaaaaaaacccccccccccaaaaaaccccacccaaaaaccccccccccaaaaaaccaaaaaaaaaaaaaaaccccccccaaaaaaaaccccccccaaajkkkkkkkaccccccaacccccc\n" +
                                                "abcccccccccccccccccccccccaaaaacacacaaaccccccccccccccaaaaaaccccccccaaaacccccccccaaaaaaacccaaaaaaaaaaaaaaaaaccccccccaaaaaccccccccccjjjkkkkkkkkccaaaaaacccccc\n" +
                                                "abcccccccccccccccccccccccaacaacccccaaacccaccccccccccaaaaaaccccccccaaaacccccccccaaaaaaacccccaaaaaacaaaaaaaacccccccaaaaacccccccjjjjjjjooopppkkkcaaaaaaaccccc\n" +
                                                "abcccccccccccccccccaacaacccccccccccaaaaaaacccccccccccaaaaacccccccccccccccccccccccaaaaaaccccaaaaaaccaaaaaaacccccccaaaaaacciijjjjjjjjoooopppkkkcaaaaaaaacccc\n" +
                                                "abccccccccccaaaccccaaaaacccccccccccccaaaaacccccccccccaaaaccccccccccccccccccccccccaacaaaccccaaaaaaacaaaaacccccccccaccaaaciiiijjjjjjoooopppppkllcaaaaaaacccc\n" +
                                                "abccaaccccccaaaaacaaaaacccccccccccccaaaaaacccccccccccccccccccccccccccccccccccccccaacccccccaaaacaaaaaaaaacccaaccccaaaaaciiiiinoooooooouuuupplllaaaaaacccccc\n" +
                                                "abcaaacccccaaaaaacaaaaaacccccccccccaaaaaaaaccccccccaacaccccccccccccccccccccccccccccccccccccaccccccccccaaccaaaccccaaaaaciiinnnooooooouuuuuppplllaaacacccccc\n" +
                                                "abaaaaaacccaaaaaacccaaaacccccccccccaaaaaaaaccccccccaaaaccccccccccccccccccccccccccccccccccccccccccccccccaaaaacaacaaaaaaiiinnnnntttoouuuuuupppllllcccccccccc\n" +
                                                "abaaaaaaccccaaaaacccaaccccccccccacccccaaccccccccccaaaaaccccccccccccccccccccccccccccccccccccccccccccccccaaaaaaaacaaaaaaiiinnnnttttuuuuxxuuupppllllccccccccc\n" +
                                                "abaaaaacccccaacaaccccccccccccccaaaccccaacccccaacccaaaaaacccccccccccccccccccccccccccccccccccccccccccccccccaaaaaccaaaaaaiiinnnttttxxuuxxyyuuppppllllcccccccc\n" +
                                                "abaaaacccccccccccccccccccccaaacaaaccccccaaacaaaaccacaaaacccccccccccccccccccccccccccccccccccaacccccccccccaaaaaccccaaaccciinnntttxxxxxxxyyvvvqqqqqlllccccccc\n" +
                                                "abaaaaaccccccccccccccccccccaaaaaaaaaacccaaaaaaacccccaaccccccccccccccccccccccccccccccccccccaaacccccccccccaacaaaccccccccciiinntttxxxxxxxyyvvvvvqqqqljjcccccc\n" +
                                                "abccaaaccaccccccccaaacccccccaaaaaaaaaccccaaaaaacccccccccccccccccccccccccccccccaacccccccaaaaacaaccccccccccccaacccccccccchhinnnttxxxxxxyyyyyvvvvqqqjjjcccccc\n" +
                                                "SbccccaaaacccccccaaaaaacccccccaaaaaccccccaaaaaaaaccccccccccccccccccccaaccccccaaaaccccccaaaaaaaacccccccccccccccccccccccchhhnnntttxxxxEzyyyyyvvvqqqjjjcccccc\n" +
                                                "abccccaaaacccccccaaaaaaccccccaaaaaacccccaaaaaaaaaacccccccccccccccccccaaccccccaaaaccccccccaaaaacccccccccccccccccccccccccchhhnntttxxxyyyyyyyvvvvqqqjjjcccccc\n" +
                                                "abcccaaaaaaccccccaaaaaacccccaaaaaaaccccaaaaaaaaaacccccccccccccccccaaaaaaaacccaaaacccccccaaaaaccccccccccccccccccccccccccchhmmmttxxxyyyyyyvvvvvqqqjjjdcccccc\n" +
                                                "abcccaaaaaacccccccaaaaacccccaaacaaacaaaaaaaaaaccccccccccccaaacccccaaaaaaaaccccccccccccccaacaaacccccccaacaaacccccccccccchhhmmmtswwwyyyyyyvvvqqqqjjjjdddcccc\n" +
                                                "abcccccaacccccccccaacaacccccccccccacaaaaaccaaaccccccccccaaaaacccccccaaaacccccccccccccccccccaaccccccccaaaaaacccccccccccchhhmmssswwwwwwyyywvrqqqjjjjdddccccc\n" +
                                                "abcccccccccccccccccccccccccccccccccaaaaaccccaaccccccccacaaaaaacccccaaaaacccccccccccccccccccccccccccccaaaaaacccccccccccchhhmmssswwwwwwywywwrrqjjjjddddccccc\n" +
                                                "abcccccccccccccccccccccccccccccccccaaaaaccccccccaaacaaacaaaaaacccccaaaaaaccccccccccccccccccccccccccccaaaaaaaccccccccccchhmmmsssswwsswwwwwwrrkkjjddddcccccc\n" +
                                                "abccccccccccccccccccccccccccccccccccaaaaacccccccaaaaaaacaaaaaccccccaaccaacccccccccccaaccccccccccccccaaaaaaaacaacaaccccchhhmmmsssssssswwwwrrrkkjddddaaccccc\n" +
                                                "abcccccccccccccccccccccccccaaaaaccccaacccccccccccaaaaaacaaaaacccccccccccccaacccccccaaaaaacccccccccccaaaaaaaacaaaaaccccchhgmmmmssssssrrwwwrrrkkddddaaaccccc\n" +
                                                "abcccccccccccccccccccccccccaaaaacccccccccccccccccaaaaaaaacccccccccccccccaaaaaaccccccaaaaaccccaaccccccccaaacccaaaaaaccccgggmmmmmmllllrrrrrrrkkkeedaaaaccccc\n" +
                                                "abcccccccccccaaccccccccccccaaaaaacccccccccccccccaaaaaaaaacccccccccccccccaaaaaaccccaaaaaaacccaaaacccccccaaccccaaaaaaccccggggmmmmllllllrrrrrkkkkeedaaaaacccc\n" +
                                                "abcccccccccccaaacaacaaaccccaaaaaaccccccccccccccaaaaaaaaaacccccccccccccccaaaaaaccccaaaaaaaaccaaaacccccccccccccaaaaaccccccgggggglllllllllrrkkkkeeeaaaaaacccc\n" +
                                                "abcccccccccccaaaaaacaaaacccaaaaaaccccccccccccccaaacaaaaaaccccccccccccccccaaaaaccccaaaaaaaaccaaaacccccccccccaaccaaaccccccgggggggggffflllkkkkkkeeeaaaaaacccc\n" +
                                                "abaccccccccaaaaaaaccaaaacccccaaacccccccccccccccccccaaaaaacaccccccccaaccccaaaacccccccaaacacccccccccccccccaaaaaccccccccccccccgggggffffflllkkkkeeeccaaacccccc\n" +
                                                "abaccccccccaaaaaaaccaaacccccccccccccccccaaaccccccccaaacaaaaaccccccaaacccccccccccccaaaacccccccccccccccccccaaaaaccccccccccccccccccaffffffkkkeeeeeccaaccccccc\n" +
                                                "abaaaccccccccaaaaaaccccccccccccccccccccaaaaaacccccccaaaaaaaacaaaacaaacccccccccaaaaaacccccccccccccccccccccaaaaaccccccccccccccccccccaffffffeeeeecccccccccccc\n" +
                                                "abaacccccccccaacaaaccccccccccccccccccccaaaaaaccccccccaaaaaccaaaaaaaaacccccccccaaaaaaaaccccccccccaaccccccaaaaacccccccccccccccccccccaaaffffeeeecccccccccccaa\n" +
                                                "abaacccccccccaaccccccccccccccccaaccccccaaaaacaaccaacccaaaaacaaaaaaaaacccccccccaaaaaaaaccccccaaacaacccccccccaacccccccccccccccccccccaaaccceaecccccccccccccaa\n" +
                                                "abaacccccccccccccccccccccccccccaaaaaacccaaaaaaaaaaaccaaacaaccaaaaaaaaaaaaacccccaaaaaaacccccccaaaaaccccccccccccccccccccccccccccccccaaacccccccccccccccaaacaa\n" +
                                                "abcccccccccccccccccccccccccccccaaaaaccccaacaacaaaaacccaaccccccaaaaaaaaaaaacccccaaaaacccccccccaaaaaaaccccccccccccccccccccccccccccccaaacccccccccccccccaaaaaa\n" +
                                                "abcccccccccccccccccccccccccccaaaaaaaccccccccaaaaaaaaccccccccccaaaaaaaaaaccccccaaaaaaccccccccaaaaaaaaccccccccccccccccccccccccccccccccccccccccccccccccaaaaaa";
}
