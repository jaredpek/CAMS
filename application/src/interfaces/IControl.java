package interfaces;

import user.User;

/** 
 * Represents an interface that control classes must implements
 * @author Jared Pek
 */
public interface IControl {
    /** 
     * Method to add objects to collection 
     * @param user The user adding an object to the collection
     */
    public void add(User user);
    /** 
     * Method to edit an object in the collection 
     * @param user The user editting an object in the collection
     */
    public void edit(User user);
    /**
     * Method to delete an object from the collection 
     * @param user The user deleting an object from the collection
     */
    public void delete(User user);
}
