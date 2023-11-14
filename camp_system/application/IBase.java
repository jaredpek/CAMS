package camp_system.application;

import java.util.Scanner;

import camp_system.date_parser.DateParse;

public interface IBase {
    public static Scanner scan = new Scanner(System.in);
    public static DateParse dateParse = new DateParse();
}
