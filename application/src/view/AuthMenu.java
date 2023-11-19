package view;

/** Represents the menus required for user authentication */
public class AuthMenu {
    /** The login menu */
    public static void login() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - Login");
        System.out.println("2 - Exit");
    }
}
