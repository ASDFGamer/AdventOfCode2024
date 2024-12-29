package de.asdfgamer.aoc2024;

public class AOC2024 {

    public static void main(String[] args) {
        Day day = new Day5();
        AbstractDay.setTesting(false);
        System.out.printf("Part 1: %s%n", day.part1());
        System.out.printf("Part 2: %s%n", day.part2());
    }
}
