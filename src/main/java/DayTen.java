import java.util.Arrays;
import java.util.List;

public class DayTen {

    private final List<String> input;
    public DayTen(String input) {
        this.input = Arrays.asList(input.split("\n"));
    }
    public long partOne() {
        long partOne = 0, register = 1, cycle = 0;
        int index = 0, delay = 0;
        while(index < input.size()) {
            cycle++;
            if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220)
                partOne += (register * cycle);;
            String parts[] = input.get(index).split(" ");
            switch (parts[0]) {
                case "noop" -> {
                    index++;
                }
                case "addx" -> {
                    if(delay == 0)
                        delay = 1;
                    else {
                        register += Integer.parseInt(parts[1]);
                        delay = 0;
                        index++;
                    }
                }
            }
        }
        return partOne;
    }

    public String partTwo() {
        StringBuilder outputBuilder = new StringBuilder();
        long register = 1, cycle = 0;
        int index = 0, delay = 0;
        while(index < input.size()) {
            outputBuilder.append(Math.abs(register - (cycle++ % 40)) <= 1 ? '#' : '.');
            String parts[] = input.get(index).split(" ");
            if(input.get(index).split(" ")[0].equals("addx")) {
                if(delay == 0)
                    delay = 1;
                else {
                    register += Integer.parseInt(parts[1]);
                    delay = 0;
                    index++;
                }
            } else
                index++;
        }

        String output = outputBuilder.toString();
        String result = "";
        for(int i = 0; i < output.length() / 40; i++)
            result += output.substring(i * 40, (i + 1) * 40) + "\n";
        return result;
    }

    public static void main(String[] args) {
        DayTen dayTen = new DayTen(data);
        System.out.println("Part one:" + dayTen.partOne());
        System.out.println("Part two:\n" +  dayTen.partTwo());
    }

    static String  data =  "noop\n" +
                    "noop\n" +
                    "addx 5\n" +
                    "addx 29\n" +
                    "addx -28\n" +
                    "addx 5\n" +
                    "addx -1\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx 5\n" +
                    "addx 12\n" +
                    "addx -6\n" +
                    "noop\n" +
                    "addx 4\n" +
                    "addx -1\n" +
                    "addx 1\n" +
                    "addx 5\n" +
                    "addx -31\n" +
                    "addx 32\n" +
                    "addx 4\n" +
                    "addx 1\n" +
                    "noop\n" +
                    "addx -38\n" +
                    "addx 5\n" +
                    "addx 2\n" +
                    "addx 3\n" +
                    "addx -2\n" +
                    "addx 2\n" +
                    "noop\n" +
                    "addx 3\n" +
                    "addx 2\n" +
                    "addx 5\n" +
                    "addx 2\n" +
                    "addx 3\n" +
                    "noop\n" +
                    "addx 2\n" +
                    "addx 3\n" +
                    "noop\n" +
                    "addx 2\n" +
                    "addx -32\n" +
                    "addx 33\n" +
                    "addx -20\n" +
                    "addx 27\n" +
                    "addx -39\n" +
                    "addx 1\n" +
                    "noop\n" +
                    "addx 5\n" +
                    "addx 3\n" +
                    "noop\n" +
                    "addx 2\n" +
                    "addx 5\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx -2\n" +
                    "addx 5\n" +
                    "addx 2\n" +
                    "addx -16\n" +
                    "addx 21\n" +
                    "addx -1\n" +
                    "addx 1\n" +
                    "noop\n" +
                    "addx 3\n" +
                    "addx 5\n" +
                    "addx -22\n" +
                    "addx 26\n" +
                    "addx -39\n" +
                    "noop\n" +
                    "addx 5\n" +
                    "addx -2\n" +
                    "addx 2\n" +
                    "addx 5\n" +
                    "addx 2\n" +
                    "addx 23\n" +
                    "noop\n" +
                    "addx -18\n" +
                    "addx 1\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx 2\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx 7\n" +
                    "addx 3\n" +
                    "noop\n" +
                    "addx 2\n" +
                    "addx -27\n" +
                    "addx 28\n" +
                    "addx 5\n" +
                    "addx -11\n" +
                    "addx -27\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx 3\n" +
                    "addx 2\n" +
                    "addx 5\n" +
                    "addx 2\n" +
                    "addx 27\n" +
                    "addx -26\n" +
                    "addx 2\n" +
                    "addx 5\n" +
                    "addx 2\n" +
                    "addx 4\n" +
                    "addx -3\n" +
                    "addx 2\n" +
                    "addx 5\n" +
                    "addx 2\n" +
                    "addx 3\n" +
                    "addx -2\n" +
                    "addx 2\n" +
                    "noop\n" +
                    "addx -33\n" +
                    "noop\n" +
                    "noop\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx 31\n" +
                    "addx -26\n" +
                    "addx 6\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx -1\n" +
                    "noop\n" +
                    "addx 3\n" +
                    "addx 5\n" +
                    "addx 3\n" +
                    "noop\n" +
                    "addx -1\n" +
                    "addx 5\n" +
                    "addx 1\n" +
                    "addx -12\n" +
                    "addx 17\n" +
                    "addx -1\n" +
                    "addx 5\n" +
                    "noop\n" +
                    "noop\n" +
                    "addx 1\n" +
                    "noop\n" +
                    "noop";
}
