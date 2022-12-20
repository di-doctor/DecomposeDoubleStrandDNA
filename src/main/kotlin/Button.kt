private const val amount = 100000
fun main() {
    var count = 0
    repeat(amount) {
        val randomA = (0 .. 1000).random()
        val randomB = (0 .. 1000).random()
        val randomC = (0 .. 1000).random()
        val nestingIf: Boolean  = when {
            randomA in (250..500) && randomB in (0..250) -> randomC in oppositeValue(randomB)..oppositeValue(randomA)
            randomB in (250..500) && randomA in (0..250) -> randomC in oppositeValue(randomA)..oppositeValue(randomB)

            randomA in (500..750) && randomB in (750..1000)->randomC in oppositeValue(randomA)..oppositeValue(randomB)
            randomB in (500..750) && randomA in (750..1000) ->randomC in oppositeValue(randomB)..oppositeValue(randomA)

            randomA in (0..250) && randomB in (750..1000) ->randomC in oppositeValue(randomB)..oppositeValue(randomA)
            randomB in (0..250) && randomA in (750..1000) ->randomC in oppositeValue(randomA)..oppositeValue(randomB)

            randomA in (250..500) && randomB in (500..750)-> randomC in oppositeValue(randomA)..1000 || randomC in 0..oppositeValue(randomB)
            randomB in (250..500) && randomA in (500..750)-> randomC in oppositeValue(randomB)..1000 || randomC in 0..oppositeValue(randomA)
            else -> false

        }

        if (nestingIf) {
            count += 1
        }
    }
    println(count)
    println("Вероятность вхождения центра круга в треугольник = ${count.toDouble() / amount * 100} ")

}

fun oppositeValue(value: Int): Int = if (value in (0 .. 500)) value + 500 else value - 500