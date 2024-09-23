import java.io.File
import kotlinx.serialization.json.Json

object BooksRepo {
    val json = Json { ignoreUnknownKeys = true }

     var booksData = listOf<Book>()
        private set



    init {
        val data = File("data/catalog-books.json").readText()
        booksData = json.decodeFromString(data)
    }

    @Throws(Exception::class)
    fun getBook(name : String): Book{
        return booksData.find { it.title == name }?: throw Exception("Not Found")
    }

    fun getBooksByPageCount(pageCount : Int): List<Book> {
        return booksData.filter { it.pageCount >= pageCount }
    }

    fun getBooksByAuthor(author : String): List<Book> {
        return booksData.filter { it.authors.contains(author) }
    }

    fun getBooksByCategory(category : String): List<Book> {
        return booksData.filter { it.categories.contains(category) }
    }
    fun getAuthorsBookCount(): Map<String, Int> {
        return booksData.groupBy { it.authors }.keys.asSequence().flatten().toSet().associateWith { getBooksByAuthor(it).size}
    }



}


