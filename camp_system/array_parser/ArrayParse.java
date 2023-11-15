package camp_system.array_parser;

import java.util.ArrayList;

public class ArrayParse {
    public String toString(ArrayList <String> data) {
        String result = "";
        for (String string : data) {
            result += string;
            result += "-";
        }
        return result;
    }
    public ArrayList <String> fromString(String data) {
        ArrayList <String> result = new ArrayList <String> ();
        String[] splitString = data.split("-");
        for (String string : splitString) {
            result.add(string);
        }
        return result;
    }
}
