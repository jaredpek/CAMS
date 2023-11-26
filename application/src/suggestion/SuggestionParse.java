package suggestion;

import java.util.ArrayList;

import csv_parser.CSVParse;

/** 
 * Represents a class that reads and writes suggestion objects to and from a CSV
 * @author Gokul Ramesh
 */
public class SuggestionParse {
    /**
     * Creates a list of suggestion objects from a CSV file
     * @param file The path to the CSV file
     * @return Arraylist of suggestion objects
     */
    public ArrayList <Suggestion> parse(String file) {
        ArrayList <Suggestion> results = new ArrayList <Suggestion> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = (new SuggestionBuild()).buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

    /**
     * Writes a list of suggestion objects to a CSV file
     * @param file The path to the CSV file
     * @param suggestions The arraylist of suggestions to be saved
     */
    public void write(String file, ArrayList <Suggestion> suggestions) {
        ArrayList <String> data = new ArrayList <String> ();
        for (Suggestion suggestion : suggestions) {
            data.add(
                suggestion.getStatus() + "," +
                suggestion.getUser() + "," +
                suggestion.getCamp() + "," +
                suggestion.getMessage()
            );
        }
        try {
            CSVParse.write(file, data);
        } catch (Exception e) {}
        
    }
}
