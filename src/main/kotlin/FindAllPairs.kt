fun main() {
    listOf<Int>(2, 4, 1)
        .map { value -> List(value) { value } }
        .also { println(it) }
        .flatten()
        .also { println(it) }
    listOf<Int>(2, 4, 1)
        .flatMap { value -> List(value) { value } }
        .also { println(it) }


}

fun duplicates(array: IntArray): Int {
    if (array.isEmpty()) return 0
    return array.groupBy { it }
        .map { entry -> entry.value.count() / 2 }
        .sumOf { it }
}

fun duplicates2(array: IntArray): Int {
    array.toSet().sumOf { i: Int -> array.count { it == i } / 2 }
    return 0
}