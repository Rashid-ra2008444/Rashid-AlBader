import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private String title;
    private Author author;
    private LocalDate datePublished;
    private double price;
    static int count = 0;
    static ArrayList<Book> books = new ArrayList<Book>();
    public Book(String title, Author author) {
        setTitle(title);
        setAuthor(author);
        count++;
        books.add(this);
    }

    public Book(String title, Author author, LocalDate datePublished) {
        this(title, author);
        setDatePublished(datePublished);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    


    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author=" + author + '}';
    }
}
