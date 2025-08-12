package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvReader {



    public static List<Map<String, String>> readCsvFileAsMap(String filePath) {
        try {
            Path path = Paths.get(filePath);
            Reader reader = new FileReader(path.toFile());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            return new ArrayList<>(csvParser.getRecords().stream()
                    .map(CSVRecord::toMap)
                    .toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file: " + filePath, e);
        }
    }
}