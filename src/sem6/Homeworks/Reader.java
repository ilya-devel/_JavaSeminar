package sem6.Homeworks;


public class Reader {
    String surname;
    String name;
    String patronymic;
    String id_reader;
    String department;
    String dateOfBirth;
    String phoneNumber;

    public Reader(String surname, String name, String patronymic, String id_reader) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.id_reader = id_reader;
    }

    public Reader(String surname, String name, String patronymic, String id_reader, String department, String dateOfBirth, String phoneNumber) {
        this(surname, name, patronymic, id_reader);
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int values) {
        System.out.printf("%s %s %s взял(а) %d книг(и)\n", surname, name, patronymic, values);
    }

    public void takeBook(String... names) {
        System.out.printf("%s %s %s взял(а) книги: ", this.surname, this.name, this.patronymic);
        for (String name: names) {
            System.out.printf("%s; ", name);
        }
        System.out.println();
    }
    public void takeBook(Book... books) {
        System.out.printf("%s %s %s взял(а) книги: ", this.surname, this.name, this.patronymic);
        for (Book book: books) {
            System.out.printf("%s; ", book.toString());
        }
    }

    public void returnBook(int values) {
        System.out.printf("%s %s %s вернул(а) %d книг(и)\n", surname, name, patronymic, values);
    }
    public void returnBook(String... names) {
        System.out.printf("%s %s %s вернул(а) книги: ", this.surname, this.name, this.patronymic);
        for (String name: names) {
            System.out.printf("%s; ", name);
        }
        System.out.println();
    }
    public void returnBook(Book... books) {
        System.out.printf("%s %s %s вернул(а) книги: ", this.surname, this.name, this.patronymic);
        for (Book book: books) {
            System.out.printf("%s; ", book.toString());
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", id_reader=" + id_reader +
                ", department='" + department + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
