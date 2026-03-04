package dam_a51597.virtual_library

class DigitalBook(
    title: String,
    author: String,
    publicationYear: String,
    availableCopies: Int,
    var fileSize: Double, // MB
    var format: FormatType
) : Book(
    title,
    author,
    publicationYear,
    availableCopies
) {
    fun getStorageInfo(): String {
        return "Stored digitally: $fileSize MB, Format: ${format}"
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(super.toString() + "\n  ")
        sb.append("Storage: " + getStorageInfo())
        return sb.toString()
    }
}