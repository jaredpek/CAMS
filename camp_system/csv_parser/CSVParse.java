package camp_system.csv_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVParse {
    public static ArrayList <String[]> read(String path) {
        ArrayList <String[]> results = new ArrayList <String[]> ();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
    public static void write(String path, ArrayList <String> data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(path));
        try {
            for (String entry : data) {
                out.println(entry);
            }
        }
        finally {
            out.close();
        }
    }
}
