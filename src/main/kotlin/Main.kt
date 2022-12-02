fun main(args: Array<String>) {
    val str = "AGGTGACACCGCAAGCCTTATATTAGC"
    println(decomposeDoubleStrand(str))
    println("****************************************************************")
    println(decomposeDoubleStrand2(str))
}

fun decomposeDoubleStrand(doubleStrand: String): String {
    val frame1 = getFrame1(doubleStrand)
    val frame2 = getFrame2(doubleStrand)
    val frame3 = getFrame3(doubleStrand)
    val reverseComplementAndRevers = doubleStrand.map {
        when (it) {
            'A' -> 'T'
            'G' -> 'C'
            'T' -> 'A'
            else -> 'G'
        }
    }.reversed().joinToString("")
    //.also { println(it) }

    val ReverseFrame1 = getFrame1(reverseComplementAndRevers)
    val ReverseFrame2 = getFrame2(reverseComplementAndRevers)
    val ReverseFrame3 = getFrame3(reverseComplementAndRevers)


    return "Frame 1: $frame1" +
            "\nFrame 2: $frame2\nFrame 3: $frame3" +
            "\n\nReverse Frame 1: $ReverseFrame1\n" +
            "Reverse Frame 2: $ReverseFrame2\n" +
            "Reverse Frame 3: $ReverseFrame3"
}

private fun getFrame2(doubleStrand: String): String {
    return "${doubleStrand.take(1)} ${doubleStrand.drop(1).chunked(3).joinToString(" ")}"
    //.also { println(it) }
}

private fun getFrame3(doubleStrand: String): String {
    return "${doubleStrand.take(2)} ${doubleStrand.drop(2).chunked(3).joinToString(" ")}"
    //.also { println(it) }
}

private fun getFrame1(doubleStrand: String): String {
    return doubleStrand
        .chunked(3)
        .joinToString(" ")
    //.also { println(it) }
}

private fun getFrame(doubleStrand: String, sizeShift: Int): String {
    return "${doubleStrand.take(sizeShift)} ${doubleStrand.drop(sizeShift).chunked(3).joinToString(" ")}"
}

fun decomposeDoubleStrand2(doubleStrand: String): String {
    val frame1 = getFrame(doubleStrand = doubleStrand, sizeShift = 0).trim()
    val frame2 = getFrame(doubleStrand = doubleStrand, sizeShift = 1)
    val frame3 = getFrame(doubleStrand = doubleStrand, sizeShift = 2)
    val reverseComplementAndRevers = doubleStrand.map {
        when (it) {
            'A' -> 'T'
            'G' -> 'C'
            'T' -> 'A'
            else -> 'G'
        }
    }.reversed().joinToString("")

    val RevFrame1 = getFrame(doubleStrand = reverseComplementAndRevers, sizeShift = 0).trim()
    val RevFrame2 = getFrame(doubleStrand = reverseComplementAndRevers, sizeShift = 1)
    val RevFrame3 = getFrame(doubleStrand = reverseComplementAndRevers, sizeShift = 2)
    return "Frame 1: $frame1" + "\nFrame 2: $frame2\nFrame 3: $frame3" + "\n\nReverse Frame 1: $RevFrame1\n" +
            "Reverse Frame 2: $RevFrame2\n" + "Reverse Frame 3: $RevFrame3"
}