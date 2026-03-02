package dam_a51597.virtual_library

import java.util.UUID

data class LibraryMember(
    var name: String,
    var membershipId: String = UUID.randomUUID().toString(),
    var borrowedBooks: MutableList<String> = mutableListOf()
) {

    fun borrowBook(library: Library, title: String) {
        val book = library.booklist.find { it.title == title } ?: run {
            println("Book '$title' not found in library.")
            return
        }

        if (book.availableCopies <= 0) {
            println("Sorry, '$title' has no available copies.")
            return
        }

        library.borrowBook(title)
        borrowedBooks.add(title)
    }

    fun returnBook(library: Library, title: String) {
        if (!borrowedBooks.contains(title)) {
            println("$name does not have '$title' borrowed.")
            return
        }

        library.returnBook(title)
        borrowedBooks.remove(title)
    }

    fun showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            println("$name has no borrowed books.")
        } else {
            println("$name's borrowed books:")
            borrowedBooks.forEach { println("  - $it") }
        }
    }

    override fun toString(): String {
        return "Name: '$name', membershipId: $membershipId, borrowedBooks:\n$borrowedBooks"
    }
}
