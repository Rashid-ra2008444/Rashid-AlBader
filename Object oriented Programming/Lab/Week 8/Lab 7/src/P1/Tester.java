package P1;

import P2.Author;
import P2.Book;
import P2.Publisher;
import P3.Chapter;

public class Tester {

	public static void main(String[] args) {
		//Address c1Address = new Address("121","Doha","Doha","000000");
        //Customer c1 = new Customer("Ahmed","33113311",123123,c1Address);
       
        //System.out.println(c1);
        
        
        Chapter ch1 = new Chapter("Chapter 1: Introduction", 10);
        Chapter ch2 = new Chapter("Chapter 2: Background", 15);
        Chapter ch3 = new Chapter("Chapter 3: Results", 20);
        Author author1 = new Author(1, "John", "Doe");
        Publisher publisher = new Publisher(1, "Pearson", "contact@pearson.com");
        Address address = new Address("123 Main St", "Anytown", "Anystate", "12345");
        publisher.setAddress(address);
        Book book1 = new Book("123-455-6656", "Art of War", 45.9);
        book1.setPublisher(publisher);
        book1.setAuthor(author1);
        book1.addChapter(ch1);
        book1.addChapter(ch2);
        book1.addChapter(ch3);
        System.out.println(book1);

        
        
        
        
        
     
    }
}
