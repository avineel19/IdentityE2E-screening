package com.ie2e.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCarReg {
    public static Set<String> extractCarReg(String filePath) throws IOException {
        String text = Files.readString(Paths.get(filePath));
        String regPattern = "\\b[A-Z]{2}[0-9]{2} ?[A-Z]{3}\\b";

        Pattern pattern = Pattern.compile(regPattern);
        Matcher matcher = pattern.matcher(text);
        Set<String> matchSet = new HashSet<>();
        while (matcher.find()) {
            matchSet.add(matcher.group());
        }
        return matchSet;
    }
}
