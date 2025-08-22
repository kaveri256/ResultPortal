package ResultPortal.Data;

import ResultPortal.Models.SatResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStore {
    private static final String FILE_NAME = "sat_results.json";
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void save(List<SatResult> results) {
        try {
            mapper.writeValue(new File(FILE_NAME), results);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static List<SatResult> load() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return new ArrayList<>();
            return Arrays.asList(mapper.readValue(file, SatResult[].class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}