package array_parser;

import java.util.ArrayList;

/** Represents an array to parse an array to and from a string representation */
public class ArrayParse {
    /**
     * Returns a string based on a list of strings using '-' as a delimitter
     * @param data The list of strings to parse
     * @return String
     */
    public static String toString(ArrayList <String> data) {
        if (data.size() == 0) return "-";
        String result = "";
        for (String string : data) {
            result += string;
            result += "-";
        }
        return result;
    }
    /**
     * Returns an array of strings based on a string input, split using '-' as a delimitter
     * @param data String input to parse
     * @return ArrayList
     */
    public static ArrayList <String> fromString(String data) {
        ArrayList <String> result = new ArrayList <String> ();
        String[] splitString = data.split("-");
        for (String string : splitString) {
            result.add(string);
        }
        return result;
    }
}
