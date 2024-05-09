package com.amaap.electionresult.service.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private final Set<String> validCityNames;

    public Validator() {
        this.validCityNames = loadValidCityNames("/validCityNames.yaml");
    }

    public boolean isValidFormat(String line) {
        String regex = "^[A-Za-z]+(?:,\\s*\\d+\\s*,\\s*[A-Za-z]+\\s*)+(?:,\\s*\\d+\\s*)*$";
        if (line.matches(regex)) return true;

        return false;
    }

    public boolean hasValidCityNames(String line) {
        String[] tokens = line.split("\\s*,\\s*");
        String cityName = tokens[0].trim();

        if (validCityNames.contains(cityName)) return true;

        return false;

    }


    public Set<String> loadValidCityNames(String filePath) {
        Set<String> cityNames = new HashSet<>();
        try (InputStream inputStream = getClass().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cityNames.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityNames;
    }
}
