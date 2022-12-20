private const val TOTAL_AMOUNT = 1000000
private const val CYCLES = 10
private const val NUMBER_OF_STEPS = 100000
fun main() {
    val cases = mutableListOf<Double>()
    repeat(CYCLES) {
        var goodCase = 0
        repeat(TOTAL_AMOUNT) {
            val randomFirst = (0..NUMBER_OF_STEPS).random()
            val randomSecond = (0..NUMBER_OF_STEPS).random()
            val range: IntRange = when {
                randomFirst < NUMBER_OF_STEPS / 2 -> 0..randomFirst
                randomFirst > NUMBER_OF_STEPS / 2 -> randomFirst..NUMBER_OF_STEPS
                else -> 0..NUMBER_OF_STEPS
            }
            if (randomSecond in range) goodCase++
        }
        //println(count)
        val result = goodCase.toDouble() / TOTAL_AMOUNT * 100
        cases.add(result)
        println(String.format("Процент треугольников захвативших центр круга = %.2f", result))

    }
    println()
    val res = cases.sum() / CYCLES
    println(String.format("Result -  %.2f", res))


}
