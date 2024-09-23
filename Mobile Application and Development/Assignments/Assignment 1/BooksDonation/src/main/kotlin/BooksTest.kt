

fun main() {
    // Read all the books from the json file
    //BooksRepo.booksData.forEach {println(it)}

    //1 Get the book with the title "Android in Action, Second Edition"
    BooksRepo.getBook("Android in Action, Second Edition").let {
        println("the book will be printed is ${it.title}")
        println("\t$it")
    }

    //2 Get all the books with page count greater than 200
    println("Books with page count of 200 or more")
    BooksRepo.getBooksByPageCount(200).forEach { println("\t$it") }

    //3 Get all the books with author "Christian Bauer"
    BooksRepo.getBooksByAuthor("Christian Bauer").let { books ->
        println("This is the books of Christian Bauer and it is ${books.size} books")
    books.forEach{println("\t$it")}
    }



    //4 Get all the books with category of Programming
    println("Books with category of Programming")
    BooksRepo.getBooksByCategory("Programming").forEach { println("\t$it") }

    //5 Count the number of books that the authors haves
    println("this is the count of books authors have")
    BooksRepo.getAuthorsBookCount().forEach {println("\t$it")}


}