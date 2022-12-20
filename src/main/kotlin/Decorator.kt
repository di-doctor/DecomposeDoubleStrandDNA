import kotlin.io.print as pr

interface Printable {
    fun print(s: String)
}

class Printer() : Printable {
    override fun print(s: String) {
        pr(s)
    }
}

class Decorator(val pr: Printable) : Printable {
    override fun print(s: String) {
        pr('"')
        pr.print(s)
        pr('"')
    }
}



fun main() {

    val str = """
        |Траектория
        |Самолета неизбежно
        |падала из за отказа двигателя
    """.trimMargin()

    println(str)
    val f:UInt = 34u
    val printer = Printer()
    printer.print("Hello")
    println()

    Decorator(Printer()).print("Hello")
}
