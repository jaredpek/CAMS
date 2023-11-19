package suggestion;

import java.util.ArrayList;

import csv_parser.CSVParse;

public class SuggestionParse {
    public static ArrayList <Suggestion> parse(String file) {
        ArrayList <Suggestion> results = new ArrayList <Suggestion> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = SuggestionBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

    public static void write(String file, ArrayList <Suggestion> suggestions) {
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
