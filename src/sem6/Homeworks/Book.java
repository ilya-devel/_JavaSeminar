package sem6.Homeworks;

public class Book {
    private String name;
    private String author;

    public Book() {
        this.name = "о чём-то";
        this.author = "кем-то";
    }
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return '"' + this.name + '"' + " " + this.author;
    }
}
