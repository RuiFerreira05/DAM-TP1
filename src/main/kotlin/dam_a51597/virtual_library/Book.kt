package dam_a51597.virtual_library

abstract class Book(
    var title: String,
    var author: String,
    // In the "Expected Implementation" section of the assignment (Section 6.3), It is suggested that "publicationYear"
    // is an Integer. This logic however, breaks when implementing point 3 of the "Book" class, which requires a custom
    // getter with a String output.
    // I therefore decided to change the type of "publicationYear" to String as it seemed to be the more logical option
    // (apart from the even more logical option of having a property called "Era", which dynamically returns the era
    // string via a custom getter)
    publicationYear: String,
    availableCopies: Int,
) {
    var publicationYear: String = publicationYear
        get() {
            return when {
                field.toInt() < 1980 -> "Classic"
                field.toInt() in 1980..2010 -> "Modern"
                else -> "Contemporary"
            }
        }

    var availableCopies: Int = availableCopies
        set(value) {
            require(value >= 0)
            if (value == 0) println("Warning: Book is now out of stock!")
            field = value
        }

    init {
        println("Book $title - $author ($publicationYear) has been created!")
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Title: $title, ")
        sb.append("Author: $author, ")
        sb.append("Era: $publicationYear, ")
        sb.append("Available: $availableCopies")
        return sb.toString()
    }
}
