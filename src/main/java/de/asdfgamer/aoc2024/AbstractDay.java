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

    protected List<String> getInput(){
        String[] nameElements = this.getClass().getName().split("\\.");
        String day = nameElements[nameElements.length-1].toLowerCase();
        try {
            return Files.readAllLines(Paths.get(Objects.requireNonNull(getClass().getResource("/inputs/"+ day)).toURI()), StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
