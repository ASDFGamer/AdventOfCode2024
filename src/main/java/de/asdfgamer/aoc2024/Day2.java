package de.asdfgamer.aoc2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 extends AbstractDay{
    @Override
    public String part1() {
        int safeReports= 0;
        for (String line : getInput()){
            List<Integer> levels = Arrays.stream(line.split("  *")).map(Integer::parseInt).toList();
            int lastLevel = levels.getFirst();
            int sign =Math.clamp(levels.get(1) - lastLevel, -1, 1);
            boolean safe = true;
            for (int i = 1; i<levels.size(); i++){
                if (lastLevel == levels.get(i)) {
                    safe = false;
                    break;
                }
                if( Math.abs(lastLevel-levels.get(i)) > 3){
                    safe = false;
                    break;
                }
                if (Math.clamp(levels.get(i)- lastLevel, -1, 1) != sign){
                    safe = false;
                    break;
                }

                lastLevel = levels.get(i);
            }
            if (safe) {
                safeReports++;
            }
        }
        return Integer.toString(safeReports);
    }

    @Override
    public String part2() {
        int safeReports= 0;
        for (String line : getInput()){
            List<Integer> levels = Arrays.stream(line.split("  *")).map(Integer::parseInt).toList();
            int oneSafe = 0;
            for (int i = 0; i < levels.size(); i++){
                List<Integer> newLevels = new ArrayList<>(levels);
                //noinspection SuspiciousListRemoveInLoop
                newLevels.remove(i);
                boolean safe = true;
                int lastLevel = newLevels.getFirst();
                int sign =Math.clamp(newLevels.get(1) - lastLevel, -1, 1);

                for (int j = 1; j<newLevels.size(); j++){
                    if (lastLevel == newLevels.get(j)) {
                        safe = false;
                        break;
                    }
                    if( Math.abs(lastLevel-newLevels.get(j)) > 3){
                        safe = false;
                        break;
                    }
                    if (Math.clamp(newLevels.get(j)- lastLevel, -1, 1) != sign){
                        safe = false;
                        break;
                    }

                    lastLevel = newLevels.get(j);
                }
                if (safe){

                    oneSafe++;
                }
            }
            if (oneSafe > 0) {
                //System.out.println("Safe:" + levels);
                safeReports++;
            }else{
                System.out.println("Not safe:" + levels);
            }
        }
        return Integer.toString(safeReports);
    }
}
