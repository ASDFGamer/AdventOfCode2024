package de.asdfgamer.aoc2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day1 extends AbstractDay{


    @Override
    public String part1() {
        List<String> input = getInput();
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        for (String line : input){
            String [] parts = line.split("  *");
            leftSide.add(Integer.parseInt(parts[0]));
            rightSide.add(Integer.parseInt(parts[1]));
        }
        leftSide.sort(Comparator.naturalOrder());
        rightSide.sort(Comparator.naturalOrder());
        int diff = 0;
        for (int i= 0; i< leftSide.size(); i++){
            diff += Math.abs(leftSide.get(i) - rightSide.get(i));
        }
        return Integer.toString(diff);
    }

    @Override
    public String part2() {
        List<String> input = getInput();
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        for (String line : input){
            String [] parts = line.split("  *");
            leftSide.add(Integer.parseInt(parts[0]));
            rightSide.add(Integer.parseInt(parts[1]));
        }
        leftSide.sort(Comparator.naturalOrder());
        rightSide.sort(Comparator.naturalOrder());
        int result = 0;
        for (int left : leftSide){
            long count = rightSide.stream().filter(integer -> integer == left).count();
            result += (int) (left*count);
        }
        return Integer.toString(result);
    }
}
