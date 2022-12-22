package sem6.Homeworks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Reader> lstReader = Control.createReaderTemplate();

        for (Reader reader: lstReader) {
            System.out.println();
            System.out.println(reader.toString());
            System.out.println();
            reader.takeBook(2);
            reader.takeBook("Math", "Genetic");
            reader.takeBook(new Book(), new Book("Война и Мир", "Л.Н. Толстой"));
            System.out.println();
            reader.returnBook(2);
            reader.returnBook("Math", "Genetic");
            reader.returnBook(new Book(), new Book("Война и Мир", "Л.Н. Толстой"));
            System.out.println();
        }
    }
}
