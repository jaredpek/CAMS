package camp_system.csv_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParse {
    public ArrayList <String[]> read(String csvFilePath) {
        ArrayList <String[]> results = new ArrayList <String[]> ();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
