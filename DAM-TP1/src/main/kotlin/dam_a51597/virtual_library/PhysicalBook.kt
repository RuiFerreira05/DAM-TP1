package dam_a51597.virtual_library

class PhysicalBook(
    title: String,
    author: String,
    publicationYear: String,
    availableCopies: Int,
    var weight: Int,
    var hasHardcover: Boolean = true
) : Book(
    title,
    author,
    publicationYear,
    availableCopies
) {
    fun getStorageInfo(): String {
        return "Physical book: ${weight}g, Hardcover: ${if (hasHardcover) "Yes" else "No"}"
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(super.toString() + "\n  ")
        sb.append("Storage: " + getStorageInfo())
        return sb.toString()
    }
}