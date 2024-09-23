import java.util.ArrayList;
import java.util.HashMap;

public class BookShop {
    ArrayList<Book> books = new ArrayList<Book>();

    public BookShop() {
        books.add(new Book("The Lord of the Rings", "Hind", 2000, "Pearson"));
        books.add(new Book("The Hobbit", "Ahmed", 2000, "Pearson"));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Huda", 2000,"IEEE"));
        books.add(new Book("The Dark Tower", "Ahmed", 2000,"IEEE"));
        books.add(new Book("The Lord of the Towers", "Huda", 2000,"Pearson"));
    }
    public static void main(String[] args) {
        new BookShop();
    }

    //Code the public instance method m1 in class BookShop
    //This method returns total price of books
    public double m1() {
        double sum = 0;
        for(Book b : books) {
            sum+=b.getPrice();
        }
        return sum;
    }

    //Code the public instance method m2 in class BookShop
    //This method returns total price of all books published by a given author
    public double m2(String author) {
        double sum = 0;
        for(Book b : books) {
            if(b.getAuthor().equals(author)) {
                sum+=b.getPrice();
            }
        }
        return sum;
    }
    //Code the public instance method m3 in class BookShop
    //This method return the number of books published by a given author
    public int m3(String author){
        int count =0;
        for(Book b : books) {
            if(b.getAuthor().equals(author)) {
                count++;
            }
        }
        return count;
    }
    //Code the public instance method m4 in class BookShop
    //This method returns all the books published by a given author
    public ArrayList<Book> m4(String author) {
        ArrayList<Book> list = new ArrayList<Book>();
        for(Book b : books) {
            if(b.getAuthor().equals(author)) {
                list.add(b);
            }
        }
        return list;
    }
    //Code the public instance method m5 in class BookShop
    //this method discounts a discount% all books published before a given year
    public void m5(int year,double discount){
        for(Book b : books) {
            if(b.getYearOfPublication()<year) {
                b.setPrice(b.getPrice()-(b.getPrice()*discount));
            }
        }
    }
    //Code the public instance method m6 in class BookShop
    //this method returns the number of books authored by a given author
    // and published by a given published before a given year
    public int m6(String author,String publisher,int year){
        int count =0;
        for(Book b : books) {
            if(b.getAuthor().equals(author) && b.getPublisher().equals(publisher) && b.getYearOfPublication()<year) {
                count++;
            }
        }
        return count;
    }
    //Code the public instance method m7 in class Book
    //this method returns the books published by a given publisher in a specific year
    public ArrayList<Book> m7(String publisher,int year){
        ArrayList<Book> list = new ArrayList<Book>();
        for(Book b : books) {
            if(b.getPublisher().equals(publisher) && b.getYearOfPublication()==year) {
                list.add(b);
            }
        }
        return list;
    }

    //Code the public instance method m8 in class BookShop
    //this method returns true if author 1 published more books than author 2 and false otherwise
    public boolean m8(String author1,String author2) {
        int count1 = 0,count2 = 0;

        for(Book b : books) {
            if(b.getAuthor().equals(author1)) {
                count1++;
            }
        }
        for(Book b : books) {
            if(b.getAuthor().equals(author2)) {
                count2++;
            }
        }
        return count1 > count2;
    }

    //Code the public instance method m9 in class BookShop
    //This method returns the book with the highest price
    public Book m9(){
        Book max = books.getFirst();
        for(Book b : books) {
            if(b.getPrice()>max.getPrice()) {
                max = b;
            }
        }
        return max;
    }

    //Code the public instance method m10 in class BookShop
    //this method display the title of books with price in range [min.max]
    public void m10(double min,double max) {
        for(Book b : books) {
            if(b.getPrice()>=min && b.getPrice()<=max) {
                System.out.println(b.getTitle());
            }
        }
    }

    //Code the public instance method m11 in class BookShop
    // this method returns the publisher having the highest number of publications in a specific year
    public String m11(int year) {
        ArrayList<String> publishers = new ArrayList<String>();
        ArrayList<Integer> countPublisher = new ArrayList<Integer>();
        String highestPublisher = "";
        int max =0;

        for(Book b : books) {
            if(!publishers.contains(b.getPublisher())){
                publishers.add(b.getPublisher());
                countPublisher.add(0);
            }
        }

        for(Book b : books) {
                if(b.getYearOfPublication()==year) {
                    int index = publishers.indexOf(b.getPublisher());
                    countPublisher.set(index, countPublisher.get(index) + 1);
                }
        }

        for(int i=0;i<publishers.size();i++) {
            if(countPublisher.get(i)>max) {
                max = countPublisher.get(i);
                highestPublisher = publishers.get(i);
            }
        }
        return  highestPublisher;
    }
    // m11 with hashMap
    public String m11WithHashMap(int year) {
        HashMap<String,Integer> publisherCount = new HashMap<String,Integer>();
        String highestPublisher = "";
        int max = 0;

        for(Book b:books) {
            if(b.getYearOfPublication() == year) {
                String publisher = b.getPublisher();
                publisherCount.put(publisher,publisherCount.getOrDefault(publisher,0)+1);
            }
        }

        for(String publisher:publisherCount.keySet()){
            int count = publisherCount.get(publisher);
            if (count > max) {
                max = count;
                highestPublisher = publisher;
            }
        }

        return highestPublisher;
    }
}
