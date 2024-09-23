package model

import java.awt.print.Book

class PaperBook(
    name :String
    ,author :String,
    val publisher: String,
    val isbn: String,
    yearOfPublication: Int

) : books(name,author, yearOfPublication) {
    override fun toString(): String {
        return "${super.toString()}, Publisher: $publisher, ISBN: $isbn"
    }
}