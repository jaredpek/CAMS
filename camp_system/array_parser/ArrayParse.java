package camp_system.array_parser;

import java.util.ArrayList;

public class ArrayParse {
    public static String toString(ArrayList <String> data) {
        if (data.size() == 0) return "-";
        String result = "";
        for (String string : data) {
            result += string;
            result += "-";
        }
        return result;
    }
    public static ArrayList <String> fromString(String data) {
        ArrayList <String> result = new ArrayList <String> ();
        String[] splitString = data.split("-");
        for (String string : splitString) {
            result.add(string);
        }
        return result;
    }
}
