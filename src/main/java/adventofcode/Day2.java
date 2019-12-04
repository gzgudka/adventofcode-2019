package adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {

    private final List<Integer> numbers;

    Day2(String input) {
        numbers = Stream.of(input.split(","))
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String input = "1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,2,0,14,0";
        System.out.println(new Day2(input).output());

        String raw = "1,%s,%s,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,2,0,14,0";
        Integer[] array = find(raw);
        int res = 100 * array[0] + array[1];
        System.out.println(res);

    }

    String run() {
        int position = 0;
        loop:
        while (position < numbers.size()) {
            int opCode = numbers.get(position);
            switch (opCode) {
                case 1: {
                    int pos1 = numbers.get(position + 1);
                    int pos2 = numbers.get(position + 2);
                    int pos3 = numbers.get(position + 3);
                    int value = numbers.get(pos1) + numbers.get(pos2);
                    numbers.set(pos3, value);
                    break;
                }
                case 2: {
                    int pos1 = numbers.get(position + 1);
                    int pos2 = numbers.get(position + 2);
                    int pos3 = numbers.get(position + 3);
                    int value = numbers.get(pos1) * numbers.get(pos2);
                    numbers.set(pos3, value);
                    break;
                }
                case 99: {
                    break loop;
                }
                default:
                    throw new RuntimeException("un-expected happened");
            }
            position += 4;
        }
        return numbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));

    }


    int output() {
        String output = run();
        return Stream.of(output.split(","))
                .map(Integer::new)
                .findFirst()
                .orElse(-1);
    }

    static Integer[] find(String raw) {
        List<Integer[]> pairs = new ArrayList<>();
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                pairs.add(new Integer[]{i, j});
            }
        }
        return pairs.stream()
                .map(pair -> {
                    String input = String.format(raw, pair[0], pair[1]);
                    int output = new Day2(input).output();
                    return new Integer[]{pair[0], pair[1], output};
                }).filter(res -> res[2] == 19690720)
                .findFirst()
                .map(x -> new Integer[]{x[0], x[1]})
                .orElse(new Integer[]{-1, -1});
    }

}
