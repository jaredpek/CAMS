package camp_system.camp;

import java.util.ArrayList;

import camp_system.IBase;

public class CampSelect implements IBase {
    public static CampDisplay campDisplay = new CampDisplay();

    public Camp select(ArrayList <Camp> camps) {
        campDisplay.printCamps(camps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        return camps.get(index - 1);
    }
}
