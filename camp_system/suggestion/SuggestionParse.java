package camp_system.suggestion;

import java.util.ArrayList;

import camp_system.csv_parser.CSVParse;

public class SuggestionParse {
    private CSVParse csvParse = new CSVParse();
    private SuggestionBuild suggestionBuild = new SuggestionBuild();

    public ArrayList <Suggestion> parse(String file) {
        ArrayList <Suggestion> results = new ArrayList <Suggestion> ();
        try {
            ArrayList <String[]> campData = csvParse.read(file);
            results = suggestionBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

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
            csvParse.write(file, data);
        } catch (Exception e) {}
        
    }
}
