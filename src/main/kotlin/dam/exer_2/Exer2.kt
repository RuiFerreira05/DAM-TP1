package dam.exer_2

fun main() {
    println("Supported operations: +, -, *, /, &&, ||, !, shl, shr")
    println("Type 'exit' at any prompt to quit.\n")

    while (true) {
        print("First Number > ")
        val input1 = readlnOrNull()?.trim()
        if (input1 == null || input1.equals("exit", ignoreCase = true)) {
            println("Exiting...")
            break
        }

        val num1: Int
        try {
            num1 = input1.toInt()
        } catch (e: NumberFormatException) {
            println("Error: '${input1}' is not a valid integer.\n")
            continue
        }

        print("Operator (+, -, *, /, &&, ||, !, shl, shr) > ")
        val operator = readlnOrNull()?.trim()
        if (operator == null || operator.equals("exit", ignoreCase = true)) {
            println("Exiting...")
            break
        }

        if (operator == "!") {
            val result = num1.inv()
            printResult("!$num1", result)
            continue
        }

        print("Second Number > ")
        val input2 = readlnOrNull()?.trim()
        if (input2 == null || input2.equals("exit", ignoreCase = true)) {
            println("Exiting...")
            break
        }

        val num2: Int
        try {
            num2 = input2.toInt()
        } catch (e: NumberFormatException) {
            println("Error: '${input2}' is not a valid integer.\n")
            continue
        }

        try {
            val result: Int = when (operator) {
                "+"   -> num1 + num2
                "-"   -> num1 - num2
                "*"   -> num1 * num2
                "/"   -> {
                    if (num2 == 0) throw ArithmeticException("Division by zero")
                    // Dado ser necessário o display do resultado em hexadécimal. Mantive os resultados de todas as
                    // operações em formato de Integer para facilitar a validação a olho nu. Este método no entanto,
                    // tem a desvantagem de, no caso da divisão, ocorrer automáticamente uma aproximação ao Integer
                    // abaixo, o que pode não ser desejável em todos os casos. Para uma precisão total, seria
                    // necessário utilizar um tipo de dado diferente, como Double, e depois converter para Integer
                    // apenas para a exibição em hexadecimal, vi no entanto essa abordagem como fora do objétivo do
                    // exercício.
                    num1 / num2
                }

                "&&"  -> num1 and num2
                "||"  -> num1 or num2
                "shl" -> num1 shl num2
                "shr" -> num1 shr num2
                else  -> {
                    println("Error: Unknown operator '${operator}'.\n")
                    continue
                }
            }

            val expression = "$num1 $operator $num2"
            printResult(expression, result)

        } catch (e: ArithmeticException) {
            println("Error: ${e.message}.\n")
        }
    }
}

private fun printResult(expression: String, result: Int) {
    val decimal = result
    val hex = "0x${"%08X".format(result)}"
    val binary = Integer.toBinaryString(result)
    val boolean = if (result != 0) "true" else "false"

    // Binary was added despite not being explicitly requested in the exercise, as it provides a better way to visually
    // validate the results of bitwise operations.

    println()
    println("+--------------------------+")
    println("| Expression : %-12s|".format(expression))
    println("+--------------------------+")
    println("| Decimal    : %-12d|".format(decimal))
    println("| Binary     : %-12s|".format(binary))
    println("| Hexadecimal: %-12s|".format(hex))
    println("| Boolean    : %-12s|".format(boolean))
    println("+--------------------------+")
    println()
}
