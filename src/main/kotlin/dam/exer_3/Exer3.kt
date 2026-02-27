package dam.exer_3

import java.math.BigDecimal
import java.math.RoundingMode


fun main() {
    val INITIAL_HEIGHT: Double = 1000.0
    var bounce_limit: Int = 15

    val sequence = generateSequence(INITIAL_HEIGHT) {
        bounce_limit--
        round(it * 0.6, 2)
    }.takeWhile { it >= 1.0 && bounce_limit > 0 }

    println(sequence.toList())
}

fun round(value: Double, places: Int): Double {
    var bd = BigDecimal.valueOf(value)
    bd = bd.setScale(places, RoundingMode.HALF_UP)
    return bd.toDouble()
}
