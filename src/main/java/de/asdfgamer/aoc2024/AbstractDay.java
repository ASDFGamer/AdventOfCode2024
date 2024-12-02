package de.asdfgamer.aoc2024;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractDay implements Day {

    private static boolean testing = false;

    public static void setTesting(boolean b) {
        AbstractDay.testing = b;
    }

    protected List<String> getInput(){
        String[] nameElements = this.getClass().getName().split("\\.");
        String day = nameElements[nameElements.length-1].toLowerCase();
        String filename = "/inputs/"+day;
        if (testing){
            filename = "/test/"+ day;
        }
        try {
            return Files.readAllLines(Paths.get(Objects.requireNonNull(getClass().getResource(filename)).toURI()), StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
