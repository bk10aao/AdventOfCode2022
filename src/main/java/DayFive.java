import java.util.*;

public class DayFive {

    List<List<Character>> stacks = new ArrayList<>();
    List<List<Integer>> moves = new ArrayList<>();

    public DayFive(String data) {
        List<String> input = new ArrayList<>();
        String[] lines = data.split("\n");

        for(String x: lines) {
            input.add(x);
        }

        for(int i = 0; i <= 9; i++)
            stacks.add(new ArrayList<>());
        List<String> stacksInput = input.subList(0, 8);
        for(String s : stacksInput)
        {
            int index = 0;
            int strIndex2 = 0;
            while(strIndex2 < s.length())
            {
                if(s.charAt(strIndex2) != ' ' && s.charAt(strIndex2) != 111 && s.charAt(strIndex2) != 'o')
                    stacks.get(index).add(0, s.charAt(strIndex2 + 1));
                index++;
                strIndex2 += 4;
            }
        }

        String actions = data.split("\n\n")[1];
        System.out.println(data);
        for(String s : actions.split("\n")) {
            String[] moveValues = s.split(" ");
            List<Integer> values = new ArrayList<>();
            if(moveValues.length == 0) {
                continue;
            }
            values.add(Integer.parseInt(moveValues[1]));
            values.add(Integer.parseInt(moveValues[3]));
            values.add(Integer.parseInt(moveValues[5]));
            moves.add(values);

        }
        System.out.println(1);
    }

    public String partOne() {
        for (List<Integer> move : moves) {
            int moveCount = move.get(0);
            int fromColumn = move.get(1);
            int toColumn = move.get(2);

            for (int i = 0; i < moveCount; i++) {
                List<Character> moveValue = stacks.get(fromColumn - 1);
                char moveChar = moveValue.get(moveValue.size() - 1);
                List<Character> updatedOriginalList = stacks.get(fromColumn - 1);
                updatedOriginalList = updatedOriginalList.subList(0, updatedOriginalList.size() - 1);
                stacks.set(fromColumn - 1, updatedOriginalList);
                stacks.get(toColumn - 1).add(moveChar);

            }
        }
        String result = "";
        for(List<Character> list : stacks) {
            if(list.size() != 0) {
                result += list.get(list.size() - 1);
            }
        }
        return result;
    }

    public String partTwo() {


        return "result";
    }

    public static void main(String[] args) {
        DayFive dayFive = new DayFive(input);
        System.out.println(dayFive.partOne());
        dayFive = new DayFive(input);
        System.out.println(dayFive.partTwo());
    }

    private static final String input = "                        [R] [J] [W]\n" +
                                        "            [R] [N]     [T] [T] [C]\n" +
                                        "[R]         [P] [G]     [J] [P] [T]\n" +
                                        "[Q]     [C] [M] [V]     [F] [F] [H]\n" +
                                        "[G] [P] [M] [S] [Z]     [Z] [C] [Q]\n" +
                                        "[P] [C] [P] [Q] [J] [J] [P] [H] [Z]\n" +
                                        "[C] [T] [H] [T] [H] [P] [G] [L] [V]\n" +
                                        "[F] [W] [B] [L] [P] [D] [L] [N] [G]\n" +
                                        " 1   2   3   4   5   6   7   8   9 \n" +
                                        "\n" +
                                        "move 2 from 2 to 8\n" +
                                        "move 2 from 1 to 6\n" +
                                        "move 8 from 7 to 1\n" +
                                        "move 7 from 5 to 4\n" +
                                        "move 1 from 6 to 4\n" +
                                        "move 1 from 6 to 3\n" +
                                        "move 6 from 3 to 5\n" +
                                        "move 9 from 8 to 1\n" +
                                        "move 3 from 6 to 7\n" +
                                        "move 14 from 4 to 1\n" +
                                        "move 6 from 1 to 7\n" +
                                        "move 16 from 1 to 9\n" +
                                        "move 6 from 1 to 4\n" +
                                        "move 1 from 8 to 6\n" +
                                        "move 4 from 1 to 5\n" +
                                        "move 11 from 9 to 7\n" +
                                        "move 2 from 1 to 8\n" +
                                        "move 1 from 6 to 7\n" +
                                        "move 1 from 8 to 7\n" +
                                        "move 1 from 8 to 3\n" +
                                        "move 7 from 4 to 3\n" +
                                        "move 14 from 7 to 6\n" +
                                        "move 8 from 6 to 9\n" +
                                        "move 19 from 9 to 2\n" +
                                        "move 1 from 1 to 2\n" +
                                        "move 2 from 9 to 7\n" +
                                        "move 9 from 7 to 8\n" +
                                        "move 2 from 2 to 8\n" +
                                        "move 16 from 2 to 9\n" +
                                        "move 4 from 8 to 2\n" +
                                        "move 1 from 7 to 9\n" +
                                        "move 3 from 9 to 6\n" +
                                        "move 3 from 3 to 6\n" +
                                        "move 11 from 9 to 2\n" +
                                        "move 7 from 5 to 3\n" +
                                        "move 2 from 5 to 9\n" +
                                        "move 6 from 6 to 4\n" +
                                        "move 1 from 6 to 4\n" +
                                        "move 4 from 6 to 8\n" +
                                        "move 5 from 9 to 1\n" +
                                        "move 4 from 1 to 7\n" +
                                        "move 3 from 2 to 6\n" +
                                        "move 3 from 4 to 1\n" +
                                        "move 1 from 4 to 1\n" +
                                        "move 2 from 1 to 3\n" +
                                        "move 4 from 3 to 7\n" +
                                        "move 1 from 5 to 2\n" +
                                        "move 3 from 1 to 6\n" +
                                        "move 15 from 2 to 5\n" +
                                        "move 3 from 6 to 3\n" +
                                        "move 13 from 3 to 8\n" +
                                        "move 2 from 4 to 2\n" +
                                        "move 9 from 5 to 4\n" +
                                        "move 2 from 2 to 5\n" +
                                        "move 5 from 7 to 5\n" +
                                        "move 10 from 8 to 6\n" +
                                        "move 1 from 2 to 5\n" +
                                        "move 10 from 4 to 6\n" +
                                        "move 4 from 8 to 6\n" +
                                        "move 3 from 7 to 1\n" +
                                        "move 3 from 1 to 9\n" +
                                        "move 1 from 2 to 1\n" +
                                        "move 8 from 5 to 2\n" +
                                        "move 3 from 6 to 9\n" +
                                        "move 6 from 8 to 5\n" +
                                        "move 6 from 9 to 2\n" +
                                        "move 1 from 1 to 9\n" +
                                        "move 10 from 2 to 1\n" +
                                        "move 4 from 8 to 5\n" +
                                        "move 10 from 5 to 9\n" +
                                        "move 11 from 9 to 7\n" +
                                        "move 5 from 7 to 9\n" +
                                        "move 1 from 9 to 2\n" +
                                        "move 3 from 2 to 9\n" +
                                        "move 2 from 2 to 8\n" +
                                        "move 4 from 9 to 5\n" +
                                        "move 4 from 1 to 9\n" +
                                        "move 5 from 5 to 2\n" +
                                        "move 5 from 1 to 4\n" +
                                        "move 21 from 6 to 9\n" +
                                        "move 3 from 2 to 9\n" +
                                        "move 2 from 8 to 1\n" +
                                        "move 25 from 9 to 6\n" +
                                        "move 4 from 5 to 7\n" +
                                        "move 1 from 4 to 6\n" +
                                        "move 6 from 6 to 4\n" +
                                        "move 3 from 4 to 6\n" +
                                        "move 7 from 7 to 3\n" +
                                        "move 4 from 9 to 1\n" +
                                        "move 3 from 7 to 8\n" +
                                        "move 2 from 9 to 8\n" +
                                        "move 2 from 2 to 8\n" +
                                        "move 4 from 1 to 3\n" +
                                        "move 9 from 6 to 2\n" +
                                        "move 13 from 6 to 4\n" +
                                        "move 13 from 4 to 5\n" +
                                        "move 1 from 5 to 8\n" +
                                        "move 2 from 2 to 3\n" +
                                        "move 6 from 5 to 3\n" +
                                        "move 19 from 3 to 6\n" +
                                        "move 1 from 4 to 9\n" +
                                        "move 2 from 8 to 1\n" +
                                        "move 5 from 2 to 3\n" +
                                        "move 5 from 1 to 9\n" +
                                        "move 7 from 5 to 4\n" +
                                        "move 1 from 8 to 3\n" +
                                        "move 1 from 2 to 6\n" +
                                        "move 8 from 6 to 3\n" +
                                        "move 1 from 9 to 8\n" +
                                        "move 11 from 4 to 2\n" +
                                        "move 1 from 4 to 6\n" +
                                        "move 1 from 2 to 8\n" +
                                        "move 5 from 3 to 4\n" +
                                        "move 4 from 9 to 6\n" +
                                        "move 1 from 6 to 8\n" +
                                        "move 9 from 3 to 1\n" +
                                        "move 7 from 2 to 9\n" +
                                        "move 1 from 2 to 6\n" +
                                        "move 3 from 1 to 8\n" +
                                        "move 2 from 2 to 3\n" +
                                        "move 3 from 9 to 7\n" +
                                        "move 3 from 4 to 7\n" +
                                        "move 2 from 4 to 3\n" +
                                        "move 2 from 3 to 5\n" +
                                        "move 8 from 6 to 4\n" +
                                        "move 6 from 8 to 6\n" +
                                        "move 2 from 9 to 4\n" +
                                        "move 5 from 8 to 6\n" +
                                        "move 3 from 7 to 5\n" +
                                        "move 1 from 5 to 8\n" +
                                        "move 1 from 8 to 2\n" +
                                        "move 1 from 5 to 1\n" +
                                        "move 11 from 4 to 9\n" +
                                        "move 2 from 6 to 3\n" +
                                        "move 2 from 2 to 4\n" +
                                        "move 6 from 1 to 2\n" +
                                        "move 6 from 2 to 1\n" +
                                        "move 3 from 7 to 3\n" +
                                        "move 2 from 4 to 7\n" +
                                        "move 4 from 6 to 5\n" +
                                        "move 7 from 3 to 7\n" +
                                        "move 5 from 9 to 6\n" +
                                        "move 22 from 6 to 8\n" +
                                        "move 2 from 6 to 5\n" +
                                        "move 2 from 8 to 4\n" +
                                        "move 14 from 8 to 7\n" +
                                        "move 11 from 7 to 4\n" +
                                        "move 3 from 8 to 1\n" +
                                        "move 9 from 7 to 8\n" +
                                        "move 10 from 1 to 4\n" +
                                        "move 1 from 7 to 4\n" +
                                        "move 4 from 8 to 7\n" +
                                        "move 6 from 4 to 9\n" +
                                        "move 7 from 4 to 1\n" +
                                        "move 3 from 4 to 8\n" +
                                        "move 1 from 5 to 8\n" +
                                        "move 8 from 5 to 3\n" +
                                        "move 4 from 3 to 9\n" +
                                        "move 7 from 8 to 9\n" +
                                        "move 3 from 8 to 3\n" +
                                        "move 2 from 8 to 2\n" +
                                        "move 7 from 9 to 1\n" +
                                        "move 2 from 2 to 8\n" +
                                        "move 8 from 9 to 1\n" +
                                        "move 8 from 1 to 7\n" +
                                        "move 7 from 1 to 5\n" +
                                        "move 7 from 7 to 1\n" +
                                        "move 11 from 9 to 8\n" +
                                        "move 9 from 8 to 5\n" +
                                        "move 2 from 8 to 5\n" +
                                        "move 3 from 1 to 8\n" +
                                        "move 2 from 3 to 7\n" +
                                        "move 6 from 4 to 1\n" +
                                        "move 6 from 1 to 6\n" +
                                        "move 5 from 7 to 1\n" +
                                        "move 2 from 4 to 6\n" +
                                        "move 1 from 3 to 5\n" +
                                        "move 4 from 7 to 4\n" +
                                        "move 2 from 8 to 7\n" +
                                        "move 10 from 5 to 6\n" +
                                        "move 9 from 6 to 1\n" +
                                        "move 8 from 1 to 6\n" +
                                        "move 1 from 7 to 2\n" +
                                        "move 9 from 6 to 4\n" +
                                        "move 2 from 4 to 3\n" +
                                        "move 3 from 8 to 1\n" +
                                        "move 1 from 2 to 4\n" +
                                        "move 4 from 4 to 1\n" +
                                        "move 7 from 4 to 3\n" +
                                        "move 3 from 3 to 2\n" +
                                        "move 1 from 7 to 6\n" +
                                        "move 9 from 6 to 7\n" +
                                        "move 6 from 7 to 4\n" +
                                        "move 2 from 7 to 2\n" +
                                        "move 6 from 4 to 7\n" +
                                        "move 2 from 2 to 9\n" +
                                        "move 1 from 2 to 4\n" +
                                        "move 1 from 7 to 4\n" +
                                        "move 4 from 7 to 6\n" +
                                        "move 4 from 5 to 4\n" +
                                        "move 1 from 2 to 5\n" +
                                        "move 1 from 7 to 5\n" +
                                        "move 1 from 2 to 6\n" +
                                        "move 6 from 4 to 3\n" +
                                        "move 9 from 3 to 9\n" +
                                        "move 4 from 6 to 2\n" +
                                        "move 7 from 3 to 8\n" +
                                        "move 22 from 1 to 7\n" +
                                        "move 1 from 1 to 7\n" +
                                        "move 2 from 8 to 3\n" +
                                        "move 4 from 5 to 6\n" +
                                        "move 2 from 3 to 2\n" +
                                        "move 6 from 2 to 8\n" +
                                        "move 3 from 8 to 6\n" +
                                        "move 1 from 4 to 8\n" +
                                        "move 1 from 1 to 8\n" +
                                        "move 8 from 6 to 7\n" +
                                        "move 7 from 8 to 9\n" +
                                        "move 22 from 7 to 4\n" +
                                        "move 3 from 5 to 6\n" +
                                        "move 1 from 8 to 1\n" +
                                        "move 2 from 8 to 2\n" +
                                        "move 3 from 6 to 4\n" +
                                        "move 1 from 1 to 3\n" +
                                        "move 15 from 9 to 1\n" +
                                        "move 5 from 1 to 5\n" +
                                        "move 3 from 7 to 6\n" +
                                        "move 5 from 5 to 6\n" +
                                        "move 4 from 4 to 3\n" +
                                        "move 6 from 6 to 9\n" +
                                        "move 7 from 7 to 6\n" +
                                        "move 5 from 6 to 7\n" +
                                        "move 4 from 1 to 9\n" +
                                        "move 3 from 7 to 4\n" +
                                        "move 2 from 9 to 7\n" +
                                        "move 5 from 3 to 5\n" +
                                        "move 3 from 6 to 3\n" +
                                        "move 5 from 4 to 6\n" +
                                        "move 10 from 9 to 5\n" +
                                        "move 1 from 2 to 9\n" +
                                        "move 1 from 3 to 5\n" +
                                        "move 1 from 2 to 9\n" +
                                        "move 3 from 1 to 6\n" +
                                        "move 2 from 9 to 2\n" +
                                        "move 7 from 6 to 5\n" +
                                        "move 15 from 4 to 9\n" +
                                        "move 2 from 4 to 5\n" +
                                        "move 1 from 3 to 4\n" +
                                        "move 9 from 9 to 1\n" +
                                        "move 1 from 9 to 2\n" +
                                        "move 2 from 9 to 4\n" +
                                        "move 11 from 5 to 4\n" +
                                        "move 1 from 9 to 3\n" +
                                        "move 1 from 6 to 8\n" +
                                        "move 4 from 7 to 8\n" +
                                        "move 4 from 8 to 9\n" +
                                        "move 15 from 4 to 7\n" +
                                        "move 1 from 6 to 7\n" +
                                        "move 1 from 3 to 7\n" +
                                        "move 6 from 9 to 6\n" +
                                        "move 1 from 3 to 7\n" +
                                        "move 1 from 2 to 1\n" +
                                        "move 1 from 9 to 5\n" +
                                        "move 3 from 6 to 1\n" +
                                        "move 11 from 1 to 4\n" +
                                        "move 6 from 5 to 1\n" +
                                        "move 2 from 2 to 5\n" +
                                        "move 1 from 5 to 7\n" +
                                        "move 2 from 6 to 1\n" +
                                        "move 7 from 5 to 7\n" +
                                        "move 3 from 5 to 6\n" +
                                        "move 4 from 6 to 1\n" +
                                        "move 11 from 4 to 3\n" +
                                        "move 1 from 8 to 5\n" +
                                        "move 23 from 7 to 6\n" +
                                        "move 18 from 6 to 9\n" +
                                        "move 1 from 5 to 9\n" +
                                        "move 1 from 4 to 2\n" +
                                        "move 3 from 3 to 7\n" +
                                        "move 3 from 3 to 8\n" +
                                        "move 17 from 1 to 8\n" +
                                        "move 5 from 6 to 5\n" +
                                        "move 2 from 7 to 1\n" +
                                        "move 20 from 8 to 2\n" +
                                        "move 4 from 7 to 2\n" +
                                        "move 3 from 9 to 5\n" +
                                        "move 7 from 9 to 7\n" +
                                        "move 6 from 9 to 2\n" +
                                        "move 1 from 1 to 8\n" +
                                        "move 3 from 9 to 4\n" +
                                        "move 7 from 5 to 2\n" +
                                        "move 6 from 7 to 1\n" +
                                        "move 1 from 1 to 8\n" +
                                        "move 3 from 2 to 6\n" +
                                        "move 1 from 7 to 6\n" +
                                        "move 2 from 8 to 9\n" +
                                        "move 35 from 2 to 4\n" +
                                        "move 3 from 3 to 2\n" +
                                        "move 1 from 5 to 7\n" +
                                        "move 2 from 3 to 9\n" +
                                        "move 3 from 1 to 6\n" +
                                        "move 2 from 2 to 1\n" +
                                        "move 32 from 4 to 7\n" +
                                        "move 3 from 4 to 8\n" +
                                        "move 3 from 9 to 5\n" +
                                        "move 1 from 1 to 2\n" +
                                        "move 21 from 7 to 5\n" +
                                        "move 2 from 2 to 1\n" +
                                        "move 3 from 1 to 2\n" +
                                        "move 15 from 5 to 1\n" +
                                        "move 3 from 6 to 7\n" +
                                        "move 3 from 4 to 6\n" +
                                        "move 3 from 8 to 5\n" +
                                        "move 1 from 9 to 3\n" +
                                        "move 8 from 7 to 2\n" +
                                        "move 6 from 5 to 2\n" +
                                        "move 9 from 1 to 6\n" +
                                        "move 4 from 7 to 1\n" +
                                        "move 2 from 5 to 4\n" +
                                        "move 2 from 4 to 3\n" +
                                        "move 3 from 5 to 4\n" +
                                        "move 17 from 2 to 7\n" +
                                        "move 3 from 3 to 5\n" +
                                        "move 2 from 4 to 8\n" +
                                        "move 1 from 4 to 3\n" +
                                        "move 5 from 7 to 9\n" +
                                        "move 1 from 3 to 6\n" +
                                        "move 4 from 1 to 7\n" +
                                        "move 4 from 6 to 7\n" +
                                        "move 2 from 5 to 2\n" +
                                        "move 1 from 1 to 3\n" +
                                        "move 10 from 6 to 4\n" +
                                        "move 1 from 3 to 7\n" +
                                        "move 20 from 7 to 8\n" +
                                        "move 8 from 4 to 8\n" +
                                        "move 1 from 2 to 8\n" +
                                        "move 4 from 9 to 1\n" +
                                        "move 3 from 7 to 4\n" +
                                        "move 2 from 4 to 9\n" +
                                        "move 2 from 6 to 3\n" +
                                        "move 1 from 2 to 8\n" +
                                        "move 1 from 7 to 6\n" +
                                        "move 1 from 9 to 5\n" +
                                        "move 3 from 5 to 9\n" +
                                        "move 4 from 9 to 2\n" +
                                        "move 1 from 4 to 5\n" +
                                        "move 1 from 5 to 3\n" +
                                        "move 3 from 2 to 4\n" +
                                        "move 1 from 9 to 7\n" +
                                        "move 1 from 2 to 1\n" +
                                        "move 1 from 7 to 1\n" +
                                        "move 11 from 1 to 2\n" +
                                        "move 3 from 1 to 7\n" +
                                        "move 25 from 8 to 5\n" +
                                        "move 1 from 6 to 3\n" +
                                        "move 1 from 6 to 2\n" +
                                        "move 7 from 8 to 2\n" +
                                        "move 9 from 2 to 8\n" +
                                        "move 2 from 4 to 7\n" +
                                        "move 2 from 5 to 7\n" +
                                        "move 2 from 5 to 2\n" +
                                        "move 5 from 5 to 1\n" +
                                        "move 7 from 5 to 1\n" +
                                        "move 2 from 4 to 9\n" +
                                        "move 3 from 5 to 6\n" +
                                        "move 1 from 1 to 8\n" +
                                        "move 1 from 5 to 6\n" +
                                        "move 1 from 4 to 7\n" +
                                        "move 1 from 9 to 2\n" +
                                        "move 3 from 5 to 2\n" +
                                        "move 2 from 6 to 9\n" +
                                        "move 3 from 9 to 8\n" +
                                        "move 1 from 5 to 4\n" +
                                        "move 3 from 3 to 9\n" +
                                        "move 10 from 1 to 5\n" +
                                        "move 4 from 2 to 8\n" +
                                        "move 2 from 6 to 1\n" +
                                        "move 3 from 9 to 7\n" +
                                        "move 1 from 1 to 9\n" +
                                        "move 1 from 4 to 3\n" +
                                        "move 1 from 9 to 2\n" +
                                        "move 9 from 8 to 2\n" +
                                        "move 2 from 3 to 7\n" +
                                        "move 2 from 7 to 6\n" +
                                        "move 3 from 5 to 6\n" +
                                        "move 4 from 8 to 6\n" +
                                        "move 4 from 8 to 3\n" +
                                        "move 4 from 3 to 2\n" +
                                        "move 4 from 6 to 8\n" +
                                        "move 1 from 7 to 9\n" +
                                        "move 2 from 1 to 8\n" +
                                        "move 2 from 8 to 3\n" +
                                        "move 1 from 9 to 2\n" +
                                        "move 13 from 2 to 4\n" +
                                        "move 6 from 5 to 7\n" +
                                        "move 2 from 5 to 7\n" +
                                        "move 10 from 2 to 4\n" +
                                        "move 11 from 7 to 8\n" +
                                        "move 1 from 6 to 4\n" +
                                        "move 4 from 6 to 7\n" +
                                        "move 24 from 4 to 9\n" +
                                        "move 11 from 7 to 4\n" +
                                        "move 1 from 3 to 8\n" +
                                        "move 1 from 3 to 5\n" +
                                        "move 4 from 4 to 2\n" +
                                        "move 5 from 4 to 2\n" +
                                        "move 9 from 2 to 5\n" +
                                        "move 4 from 9 to 5\n" +
                                        "move 1 from 5 to 1\n" +
                                        "move 2 from 5 to 7\n" +
                                        "move 2 from 2 to 5\n" +
                                        "move 1 from 1 to 7\n" +
                                        "move 2 from 2 to 3\n" +
                                        "move 18 from 9 to 6\n" +
                                        "move 9 from 8 to 1\n" +
                                        "move 2 from 9 to 5\n" +
                                        "move 5 from 1 to 8\n" +
                                        "move 2 from 8 to 7\n" +
                                        "move 4 from 8 to 4\n" +
                                        "move 5 from 8 to 7\n" +
                                        "move 10 from 5 to 1\n" +
                                        "move 10 from 7 to 4\n" +
                                        "move 4 from 5 to 8\n" +
                                        "move 14 from 1 to 9\n" +
                                        "move 6 from 9 to 8\n" +
                                        "move 1 from 5 to 1\n" +
                                        "move 12 from 6 to 9\n" +
                                        "move 4 from 6 to 8\n" +
                                        "move 11 from 8 to 5\n" +
                                        "move 1 from 6 to 1\n" +
                                        "move 19 from 9 to 7\n" +
                                        "move 2 from 3 to 5\n" +
                                        "move 13 from 7 to 5\n" +
                                        "move 3 from 7 to 1\n" +
                                        "move 4 from 8 to 9\n" +
                                        "move 2 from 7 to 6\n" +
                                        "move 7 from 4 to 8\n" +
                                        "move 5 from 8 to 1\n" +
                                        "move 1 from 1 to 3\n" +
                                        "move 1 from 7 to 2\n" +
                                        "move 6 from 1 to 6\n" +
                                        "move 1 from 2 to 5\n" +
                                        "move 1 from 8 to 1\n" +
                                        "move 1 from 8 to 2\n" +
                                        "move 2 from 4 to 8\n" +
                                        "move 5 from 6 to 1\n" +
                                        "move 2 from 4 to 7\n" +
                                        "move 2 from 9 to 6\n" +
                                        "move 1 from 6 to 5\n" +
                                        "move 4 from 6 to 2\n" +
                                        "move 1 from 9 to 5\n" +
                                        "move 2 from 4 to 5\n" +
                                        "move 4 from 2 to 4\n" +
                                        "move 2 from 8 to 3\n" +
                                        "move 3 from 3 to 2\n" +
                                        "move 4 from 1 to 2\n" +
                                        "move 2 from 4 to 7\n" +
                                        "move 4 from 2 to 3\n" +
                                        "move 4 from 1 to 2\n" +
                                        "move 13 from 5 to 1\n" +
                                        "move 1 from 6 to 2\n" +
                                        "move 1 from 1 to 8\n" +
                                        "move 15 from 5 to 2\n" +
                                        "move 4 from 3 to 1\n" +
                                        "move 5 from 4 to 3\n" +
                                        "move 1 from 3 to 6\n" +
                                        "move 1 from 8 to 7\n" +
                                        "move 1 from 9 to 8\n" +
                                        "move 1 from 7 to 8\n" +
                                        "move 3 from 3 to 2\n" +
                                        "move 1 from 8 to 2\n" +
                                        "move 1 from 3 to 7\n" +
                                        "move 13 from 1 to 4\n" +
                                        "move 3 from 5 to 3\n" +
                                        "move 1 from 1 to 2\n" +
                                        "move 1 from 8 to 5\n" +
                                        "move 5 from 7 to 2\n" +
                                        "move 1 from 6 to 5\n" +
                                        "move 2 from 3 to 4\n" +
                                        "move 10 from 2 to 5\n" +
                                        "move 1 from 9 to 5\n" +
                                        "move 3 from 1 to 8\n" +
                                        "move 3 from 8 to 3\n" +
                                        "move 11 from 4 to 5\n" +
                                        "move 12 from 2 to 8\n" +
                                        "move 4 from 4 to 7\n" +
                                        "move 10 from 8 to 5\n" +
                                        "move 2 from 8 to 1\n" +
                                        "move 1 from 7 to 3\n" +
                                        "move 1 from 7 to 9\n" +
                                        "move 5 from 3 to 7\n" +
                                        "move 1 from 9 to 4\n" +
                                        "move 7 from 7 to 6\n" +
                                        "move 13 from 5 to 8\n" +
                                        "move 6 from 6 to 7\n" +
                                        "move 5 from 7 to 4\n" +
                                        "move 1 from 6 to 4\n" +
                                        "move 2 from 4 to 9\n" +
                                        "move 1 from 7 to 9\n" +
                                        "move 3 from 4 to 3\n" +
                                        "move 1 from 3 to 6\n" +
                                        "move 4 from 5 to 7";
}