public class Book {
    private String title;
    private String author;
    private double price;
    private int yearOfPublication;
    private String publisher;
    public Book(String title, String author, int yearOfPublication , String publisher) {
        setTitle(title);
        setAuthor(author);
        setYearOfPublication(yearOfPublication);
        setPublisher(publisher);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
