import com.sun.jdi.CharType;

import java.util.*;

public class DayFive {

    List<List<Character>> stacks = new ArrayList<>();
    List<List<Integer>> moves = new ArrayList<>();

    public DayFive(String data) {
        List<String> input = Arrays.asList(data.split("\n"));
        List<List<Character>> stacks = new ArrayList<>();
        for(int i = 0; i < 9; i++)
            stacks.add(new ArrayList<>());
        List<String> stacksInput = input.subList(0, 8);
        for(String s : stacksInput)
        {
            int index = 0;
            int strIndex2 = 0;
            while(strIndex2 < s.length())
            {
                if(s.charAt(strIndex2) != ' ')
                    stacks.get(index).add(0, s.charAt(strIndex2 + 1));
                index++;
                strIndex2 += 4;
            }
        }

        List<List<Character>> copy = new ArrayList<>();
        for(int i = 0; i < 9; i++)
            copy.add(new ArrayList<>(stacks.get(i)));

        List<String> instructions = input.subList(10, input.size());
        for(String i : instructions)
        {
            //Part 1
            String[] parts = i.split(" ");
            int toMove = Integer.parseInt(parts[1]);
            int from = Integer.parseInt(parts[3]) - 1;
            int to = Integer.parseInt(parts[5]) - 1;
            List<Character> fromStack = stacks.get(from);
            List<Character> toStack = stacks.get(to);
            List<Character> moving = new ArrayList<>();
            for(int j = 0; j < toMove; j++)
                moving.add(fromStack.remove(fromStack.size() - 1));
            toStack.addAll(moving);

            //Part 2
            fromStack = copy.get(from);
            toStack = copy.get(to);
            moving = new ArrayList<>();
            for(int j = 0; j < toMove; j++)
                moving.add(0, fromStack.remove(fromStack.size() - 1));
            toStack.addAll(moving);
        }
        StringBuilder str = new StringBuilder();
        for(List<Character> stack : stacks)
            str.append(stack.get(stack.size() - 1));
        System.out.println(str);
        str = new StringBuilder();
        for(List<Character> stack : copy)
            str.append(stack.get(stack.size() - 1));
        System.out.println(str);
    }
//
//    public String partOne() {
//        for(List<Integer> s : moves) {
//            System.out.println(moves);
//            int count = s.get(0);
//            int from = s.get(1);
//            int to = s.get(2);
//            System.out.printf("move %d from %d to %d\n", count, from, to);
//
//            List<Character> startColumn = stacks.get(from - 1);
//            List<Character> moveList = new ArrayList<>();
//            for(int c = startColumn.size() - count; c < startColumn.size(); c++) {
//                if(c > startColumn.size() - 1) {
//                    break;
//                }
//                moveList.add(startColumn.get(c));
//            }
//
//            startColumn.removeAll(moveList);
//
//            List<Character> reversed = new ArrayList<>();
//            for(int i = moveList.size() - 1; i >= 0; i--) {
//                reversed.add(moveList.get(i));
//            }
//
//            List<Character> toColumn = stacks.get(to - 1);
//            toColumn.addAll(reversed);
//            stacks.set(to - 1, toColumn);
//            System.out.println(1234);
//
//        }
//
//        String result = "";
//        for(List<Character> stack : stacks) {
//            try {
//                result += stack.get(stack.size() - 1);
//            } catch(Exception e) {
//                //do nothing
//            }
//        }
//        return result;
//    }

//    public String partTwo() {
//
//
//        return "result";
//    }

    public static void main(String[] args) {
        DayFive dayFive = new DayFive(input);
//        dayFive = new DayFive(input);
//        System.out.println(dayFive.partTwo());
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