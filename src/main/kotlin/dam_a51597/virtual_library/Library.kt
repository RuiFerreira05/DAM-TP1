package dam_a51597.virtual_library

import kotlin.toString

class Library(var name: String) {

    var booklist: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        booklist.add(book)
        totalBooksAdded++
        println("Book '${book.title}' by ${book.author} has been added to the library")
    }

    fun borrowBook(title: String) {
        // the "?:", which translates to "Elvis operator" will handle null cases
        val book = booklist.find { it.title == title } ?: run {
            println("Could not find book")
            return
        }

        if (book.availableCopies == 0) {
            println("Sorry, book '${book.title}' has no more available copies")
        } else {
            book.availableCopies--
            println("Successfully borrowed '${book.title}'. Copies remaining: ${book.availableCopies} ")
        }
    }

    fun returnBook(title: String) {
        val book = booklist.find { it.title == title } ?: run {
            println("Could not find book")
            return
        }

        book.availableCopies++
        println("Book '${book.title}' returned successfully. Copies available: ${book.availableCopies} ")
    }

    fun showBooks() {
        println(this)
    }

    fun searchByAuthor(author: String) {

        val str = StringBuilder().append("Books by $author:\n")

        booklist.forEach {
            if (it.author == author) {
                str.append("  - ${it.title} (${it.publicationYear}, ${it.availableCopies} ${if (it.availableCopies > 1) "copies" else "copy"} available)\n")
            }
        }

        println(str.toString())
    }

    override fun toString(): String {
        return buildString {
            appendLine("--- Library Catalog ---")
            for (book in booklist) {
                appendLine(book.toString())
            }
        }
    }

    companion object {
        var totalBooksAdded: Int = 0

        fun getTotalBooksCreated(): Int {
            return totalBooksAdded
        }
    }

}