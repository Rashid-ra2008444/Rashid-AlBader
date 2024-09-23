package P2;

import java.util.ArrayList;

import P3.Chapter;

public class Book {

	private String isbn;
	private String title;
	private double price;
	private Author author;
	private Publisher publisher;
	ArrayList<Chapter> chapters = new ArrayList<>();

	public Book(String isbn, String title, double price) {
		setTitle(title);
		setIsbn(isbn);
		setPrice(price);
	}
	
	public Book(String isbn, String title, double price, Author author) {
			this(isbn, title, price);
			setAuthor(author);
	}
	

	public Book(String isbn, String title, double price, Author author, Publisher publisher) {
		this(isbn, title, price, author);
        setPublisher(publisher);
	}
	
	
	
	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return String.format(
				"%s[%s] by %s, %s\nPublished by: %s,%s\n(%d Chapters,%d Pages,$%.2f,ISBN %s)",
				title,isbn,author.getLastName(),author.getFirstName(),
				publisher.getEmail(),publisher.getAddress().toString(),
				chapters.size(),getPageCount(),price,isbn
				);
	}

	
	public void addChapter(Chapter c) {
		chapters.add(c);
	}
	
    public void removeChapter(Chapter c) {
        chapters.remove(c);
    }
    
    public int getPageCount() {
    		int count = 0;
        for(Chapter c : chapters) {
            count += c.getPageCount();
        }
        return count;
    }
    
    public int getChapterCount() {
    	return chapters.size();
    }
    public Chapter getLongestChapter() {
    	int max = 0;
    	Chapter ch = null;
    	for(Chapter c : chapters) {
    			if(c.getPageCount() > max) {
                max = c.getPageCount();
                ch = c;}
    	}
    	return ch;
    }
    public Chapter getShortestChapter() {
    	int min = getLongestChapter().getPageCount();
    	Chapter ch = null;
    	for(Chapter c : chapters) {
    		if(c.getPageCount() < min) {
    			min = c.getPageCount();
    			ch = c;
    		}
    	}
    	return ch;
    }
    
    public double getAvgNumOfPages() {
    		double sum = 0;
        for(Chapter c : chapters) {
            sum += c.getPageCount();
        }
        return sum / chapters.size();
    }
}
