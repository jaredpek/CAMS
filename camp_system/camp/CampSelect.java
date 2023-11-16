package camp_system.camp;

import java.util.ArrayList;

import camp_system.scanner.Scan;

public class CampSelect {
    public static Camp select(ArrayList <Camp> camps) {
        CampDisplay.printCamps(camps);
        if (camps.size() == 0) return null;
        System.out.printf("Camp: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        return camps.get(index - 1);
    }
}
