package de.asdfgamer.aoc2024;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Day4 extends AbstractDay {
    @Override
    public String part1() {
        int count = 0;
        List<String> input = getInput();
        String searchWord = "XMAS";
        List<char[]> tempArray = input.stream().map(String::toCharArray).toList();
        char[][] inputArray = tempArray.toArray(char[][]::new);
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                count += findWord(inputArray, i, j, 1, 0, searchWord);
                count += findWord(inputArray, i, j, 1, 1, searchWord);
                count += findWord(inputArray, i, j, 0, 1, searchWord);
                count += findWord(inputArray, i, j, -1, 1, searchWord);
                count += findWord(inputArray, i, j, -1, 0, searchWord);
                count += findWord(inputArray, i, j, -1, -1, searchWord);
                count += findWord(inputArray, i, j, 0, -1, searchWord);
                count += findWord(inputArray, i, j, 1, -1, searchWord);
            }
        }
        return Integer.toString(count);
    }

    private int findWord(@NotNull char[][] inputArray, int pos_x, int pos_y, int x_dir, int y_dir, @NotNull String searchWord) {
        int end_x = pos_x + (searchWord.length() - 1) * x_dir;
        int end_y = pos_y + (searchWord.length() - 1) * y_dir;
        if (end_x >= inputArray.length || end_x < 0) {
            return 0;
        }
        if (end_y >= inputArray[0].length || end_y < 0) {
            return 0;
        }
        int cur_x = pos_x;
        int cur_y = pos_y;
        for (int i = 0; i < searchWord.length(); i++) {
            if (inputArray[cur_x][cur_y] != searchWord.charAt(i)) {
                return 0;
            }
            cur_x += x_dir;
            cur_y += y_dir;
        }
        //System.out.println("Found word at " + pos_x + " " + pos_y + "(" + x_dir + "," + y_dir + ")");
        return 1;
    }

    @Override
    public String part2() {
        int count = 0;
        List<String> input = getInput();
        char[][] inputArray = input.stream().map(String::toCharArray).toArray(char[][]::new);
        for (int i = 1; i < inputArray.length - 1; i++) {
            for (int j = 1; j < inputArray[i].length - 1; j++) {
                count += findWordX(inputArray, i, j, 1, 0, 0, 1);
                count += findWordX(inputArray, i, j, 1, 0, 0, -1);
                count += findWordX(inputArray, i, j, -1, 0, 0, 1);
                count += findWordX(inputArray, i, j, -1, 0, 0, -1);
                count += findWordX(inputArray, i, j, 1, 1, 1, -1);
                count += findWordX(inputArray, i, j, 1, 1, -1, 1);
                count += findWordX(inputArray, i, j, -1, -1, -1, 1);
                count += findWordX(inputArray, i, j, -1, -1, 1, -1);
            }
        }
        return Integer.toString(count);
    }

    private int findWordX(@NotNull char[][] inputArray, int mid_x, int mid_y, int x_dir, int y_dir, int x_dir2, int y_dir2) {
        String searchWord = "MAS";
        int cur_x = mid_x - x_dir;
        int cur_y = mid_y - y_dir;
        for (int i = 0; i < searchWord.length(); i++) {
            if (inputArray[cur_x][cur_y] != searchWord.charAt(i)) {
                return 0;
            }
            cur_x += x_dir;
            cur_y += y_dir;
        }
        cur_x = mid_x - x_dir2;
        cur_y = mid_y - y_dir2;
        for (int i = 0; i < searchWord.length(); i++) {
            if (inputArray[cur_x][cur_y] != searchWord.charAt(i)) {
                return 0;
            }
            cur_x += x_dir2;
            cur_y += y_dir2;
        }
        //System.out.println("Found word at " + "(" + x_dir + "," + y_dir + "), (" + x_dir2 + "," + y_dir2 + ")");
        return 1;
    }
}
