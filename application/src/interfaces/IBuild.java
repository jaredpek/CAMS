package interfaces;

import java.util.ArrayList;

/** 
 * Represents an interface for object builder classes
 * @author Jared Pek
 */
public interface IBuild {
    /**
     * Builds a new object based on an array of strings
     * @param data An array of strings
     * @return A new object 
     */
    public Object build(String[] data);
    /**
     * Returns a new arraylist of objects
     * @param data Arraylist of data entries
     * @return ArrayList of new objects
     */
    public ArrayList buildMany(ArrayList <String[]> data);
}
