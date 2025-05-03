package com.ie2e.utils;

import com.ie2e.data.parse.CarDetails;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.ie2e.config.ConfigReader.getProperty;

public class ReadCarOutputFile {
    public static List<CarDetails> readCarOutputFile() throws IOException {
        return Files.lines(Path.of(getProperty("output.file")))
                .filter(line->!(line.trim().isEmpty()))
                .map(ReadCarOutputFile::getCarDetails)
                .collect(Collectors.toList());
    }

    private static CarDetails getCarDetails(String line) {
        String[] split = line.split(",");
        return new CarDetails(StringUtils.replace(split[0].trim()," ",""),
                split[1].trim(), split[2].trim(), split[3].trim());
    }
}
