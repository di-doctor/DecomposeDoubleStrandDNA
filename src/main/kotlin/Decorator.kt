interface Printable{
    fun print()
}

class Printer(val str:String): Printable{
    override fun print() {
        print(str)
    }
}

class Decorator(val pr: Printable) : Printable {
    override fun print() {
        print('"')
        pr.print()
        println('"')
    }
}

fun main() {
    Printer("Hello").let {
        Decorator(it).print()
    }
}