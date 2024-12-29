package de.asdfgamer.aoc2024;

import java.util.*;

public class Day5 extends AbstractDay {
    @Override
    public String part1() {
        int result = 0;
        boolean firstPart = true;
        var pageOrderings = new HashMap<Integer, Set<Integer>>();
        var printouts = new LinkedList<List<Integer>>();
        for (String line : getInput()) {
            if (line.isBlank()) {
                firstPart = false;
                continue;
            }
            if (firstPart) {
                var parts = line.split("\\|");
                int firstPage = Integer.parseInt(parts[0]);
                int secondPage = Integer.parseInt(parts[1]);
                pageOrderings.putIfAbsent(firstPage, new HashSet<>());
                pageOrderings.get(firstPage).add(secondPage);
            } else {
                var parts = Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
                printouts.add(parts);
            }
        }
        for (var printout : printouts) {
            boolean valid = true;
            var mutPrintout = new LinkedList<>(printout);
            var prevPages = new LinkedList<Integer>();
            for (int i = 0; i < printout.size(); i++) {
                int currentPage = mutPrintout.removeFirst();
                Set<Integer> followingPages = pageOrderings.getOrDefault(currentPage, new HashSet<>());
                if (followingPages.isEmpty()) {
                    prevPages.add(currentPage);
                    continue;
                }
                boolean ok = true;
                for (var followingPage : followingPages) {
                    if (prevPages.contains(followingPage)) {
                        ok = false;

                        break;
                    }
                }
                prevPages.add(currentPage);
                if (!ok) {
                    valid = false;
                }
            }
            if (valid) {
                System.out.println(printout);
                int middle = (printout.size() / 2) + 1;
                int middleNumber = printout.get(middle - 1);
                System.out.println(middleNumber);
                result += middleNumber;
            }

        }
        return Integer.toString(result);
    }

    @Override
    public String part2() {
        return "";
    }
}
