package sem6.Homeworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Control {
    public static String[][] lstPersons = new String[][]{
            {"Black", "Jack", "Orion", "RD1001", "Economic", "1988-08-12", "998-33-1"},
            {"Black", "Izabella", "Laura", "RX1701", "Biology", "1995-01-23", "958-13-5"}
    };

    public static List<Reader> createReaderTemplate() {
        List<Reader> lstReader = new ArrayList<>();
        for (String[] person : lstPersons) {
             lstReader.add(new Reader(person[0], person[1], person[2], person[3], person[4], person[5],person[6]));
        }
        return lstReader;
    }

    public static List<Reader> createReaders(int values) {
        List<Reader> lstReader = new ArrayList<>();
        for (int i = 0; i < values; i++) {
            lstReader.add(createReaderHand());
        }
        return lstReader;
    }

    public static Reader createReaderHand() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите фамилию:");
        String surname = in.nextLine();
        System.out.println("Введите имя:");
        String name = in.nextLine();
        System.out.println("Введите отчество:");
        String patronymic = in.nextLine();
        System.out.println("Введите номер читательского билета:");
        String id_reader = in.nextLine();
        System.out.println("Введите факультет:");
        String department = in.nextLine();
        System.out.println("Введите дату рождения:");
        String dateOfBirth = in.nextLine();
        System.out.println("Введите телефонный номер:");
        String phoneNumber = in.nextLine();
        return new Reader(surname, name, patronymic, id_reader, department, dateOfBirth, phoneNumber);
    }
}
