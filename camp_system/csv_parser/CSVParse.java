package camp_system.csv_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/** Represents a class that reads and writes to and from a CSV file */
public class CSVParse {
    /**
     * Returns a 2D list of strings based on data from a provided CSV file
     * @param path Path to the CSV file
     * @return ArrayList
     */
    public static ArrayList <String[]> read(String path) {
        ArrayList <String[]> results = new ArrayList <String[]> ();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error reading from CSV");
        }
        return results;
    }
    /**
     * Writes a list of strings to a CSV file
     * @param path Path to the CSV file
     * @param data List of strings to write to CSV
     * @throws IOException 
     */
    public static void write(String path, ArrayList <String> data) {
        try  {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            for (String entry : data)  out.println(entry);
            out.close();
        }
        catch (IOException e) {
            System.out.println("Error writing to CSV");
        }
    }
}
