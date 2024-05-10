package com.amaap.electionresult.domain.model;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class PartyNameMapper {
    private Map<String, String> parties;

    public PartyNameMapper() {
        loadPartyCodesAndNames();
    }

    private void loadPartyCodesAndNames() {
        String yamlFilePath = "D:\\ElectionResult\\src\\main\\resources\\validPartyCodes.yaml";
        try (InputStream inputStream = Files.newInputStream(Paths.get(yamlFilePath))) {
            Yaml yaml = new Yaml();
            Map<String, Map<String, String>> data = yaml.load(inputStream);
            parties = data.get("parties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPartyFullName(String partyCode) {
        if (parties.containsKey(partyCode)) {
            return parties.get(partyCode);
        } else {
            return "Unknown Party Code Exception";
        }
    }
}
