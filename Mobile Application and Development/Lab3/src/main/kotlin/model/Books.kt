package model

abstract class books (
    val name :String,
    val author :String,
    val yearOfPublication :Int



)
{
    override fun toString(): String {
        return "Name: $name, Author: $author, Year of Publication: $yearOfPublication"
    }

}

