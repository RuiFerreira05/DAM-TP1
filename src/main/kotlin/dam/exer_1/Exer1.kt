package dam.exer_1

fun main() {
    val a = IntArray(50) { (it + 1) * (it + 1) } // int[]
    val b = (1..50).map { it * it }.toIntArray() // int[]
    val c = Array(50) { (it + 1) * (it + 1) } // Integer[]

    println("A: ${a.contentToString()}")
    println("B: ${b.contentToString()}")
    println("C: ${c.contentToString()}")
}
