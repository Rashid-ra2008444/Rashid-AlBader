public class App {
    public App() {
        //Create the object bookshop from the class Bookshop using the
        // a name provided by the user at command line.
        BookShop bookshop = new BookShop();

        //Take advantage of appropriate method(s) of Bookshop to
        //display the total price of all books.
            bookshop.m1();

        //Take advantage of appropriate method(s) of Bookshop to
        //display the total price of all books authored by "Hind"

            bookshop.m2("Hind");

        //Take advantage of appropriate method(s) of Bookshop to
        //display the number of books authored by "Ahmed"

            bookshop.m3("Ahmed");

        //Take advantage of appropriate method(s) of Bookshop to
        //display the book titles authored by "Huda"

            bookshop.m4("Huda");

        //Take advantage of appropriate method(s) of Bookshop to
        //discount all books published before the year 2000 by 40%

            bookshop.m5(2000,0.40);

        //Take advantage of appropriate method(s) of Bookshop to
        //display the number of books authored by "Ahmed" and published
        //by Pearson before the year 2000

            bookshop.m6("Ahmed", "Pearson", 2000);

        //Take advantage of appropriate method(s) of Bookshop to
        //display titles of books published by McHill in the year 2023

            bookshop.m7("McHill",2023);

        //Take advantage of appropriate method(s) of Bookshop to
        //to display the result of checking if "Hind" authored more
        //books than "Ahmed" or not.

            bookshop.m8("Hind", "Ahmed");

        //Take advantage of appropriate method(s) of Bookshop to
        //display the title of the most expensive book

            bookshop.m9();

        //Take advantage of appropriate method(s) of Bookshop to
        //display the titles of books with price in [100,300]

            bookshop.m10(100,300);


            System.out.println(bookshop.m11(2000));
            System.out.println(bookshop.m11WithHashMap(2000));
    }

    public static void main(String[] args) {
        //Create an anonymous abject of this class
        new App();
    }
}
