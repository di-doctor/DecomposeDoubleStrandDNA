open class Base(val name: String) {
    init {
        println("Инициализация класса Base")
    }
    open val size: Int =
        name.length.also { println("Инициализация свойства size в класса Base: $it") }
}
class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }
    .also { println("Аргументы, переданные в конструктор класса Base: $it") }) {
    init {
        println("Инициализация класса Derived")
    }
    override val size: Int =
        (super.size + lastName.length).also { println("Инициализация свойства size в классе Derived: $it") }
    var id: Int = 0
        get() {
            if (name.length == id) return field else return 0
        }
        set(value) {
            if (value > 0) field = value
        }
}


fun main() {
    Base("dima").let {
        println(it.name)
        println(it.size)
    }
    Derived("danya", "Tambovskiy").let {
        println(it.name)
        println(it.lastName)
        println(it.size)
    }
}


//    val lst1 = arrayOf(longArrayOf(1, 2), longArrayOf(1, 3), longArrayOf(1, 4))
//    val lst2 = arrayOf(longArrayOf(69, 130), longArrayOf(87, 1310), longArrayOf(30, 40))
//    val lst3 = arrayOf(longArrayOf(1, 5), longArrayOf(2, 6), longArrayOf(3, 4), longArrayOf(3, 2), longArrayOf(3, 4))
//    println(convertFrac(lst1))
//    println(convertFrac(lst2))
//    println(convertFrac(lst3))


fun convertFrac(lst: Array<LongArray>): String {
    if (lst.isEmpty()) return ""
    var commonDenominator = lst.fold(1L) { acc, longs -> smallestDenominator(acc, longs.last()) }
    var delimoe = 1
    while (lst.all { longs: LongArray ->
            val d = commonDenominator / delimoe



            true
        }) {
        delimoe++
    }
    commonDenominator /= delimoe


    /* var delimoe = 1
     var commonDelimDouble = commonDenominator.toDouble()
     while (lst.all { longs: LongArray ->
             val d = commonDelimDouble / longs.last() * longs.first()/delimoe % 2
             d > -0.001 && d <0.001
         }) {
         delimoe++
     }
     commonDenominator = (commonDelimDouble/delimoe).toLong()*/
    return lst.map { longs: LongArray -> longs.first() * commonDenominator / longs.last() }
        .joinToString("") { l: Long -> "($l,$commonDenominator)" }
}

private fun smallestDenominator(firstValue: Long, secondValue: Long): Long { //наименьший знаменатель
    var oneV = firstValue
    var twoV = secondValue
    while (oneV != twoV) {
        if (oneV > twoV) {
            oneV -= twoV
        } else {
            twoV -= oneV
        }
    }
    return firstValue * secondValue / oneV
}

/*fun smallestDenominator2(array: LongArray): Long {
    var max = 0L
    for (i in 0 until array.size - 1) {
        for (j in 1 until array.size) {
            val max2 = nok(array[i], array[j])
            if (max < max2) max = max2
        }
    }
    return max
}

private fun nod(a: Long, b: Long): Long {
    return if (b == 0L) a else nod(b, a % b)

}

private fun nok(a: Long, b: Long): Long {
    return a / nod(a, b) * b
}*/

/*
public static int commonDenominator(int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length-1; i++) {
        for (int j = 1; j < arr.length ; j++) {
        int max2 = nok(arr[i], arr[j]);
        if (max < max2) {
            max = max2;
        }
    }
    }
    return max;
}
 
public static int nod(int a, int b) {
    return b == 0 ? a : nod(b, a % b);
}
 
public static int nok(int a, int b) {
    return a / nod(a, b) * b;
}*/
