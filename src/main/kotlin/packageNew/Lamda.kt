package packageNew

import kotlin.reflect.KProperty

interface Base {
    val message: String
    fun print()
}

class BaseImpl(private val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() {
        println(message)
    }
}


data class Test(val id: Int) {
    val l: String by Delegate1()
    }

class Delegate1  {
    operator fun getValue(reference: Test, property: KProperty<*>): String {
       return "reference - ${reference}, property_Name-${property.name}"
    }


}



class Derived(b: Base) : Base by b {
    // Это свойство недоступно из `b` реализации `print`
    override val message = "Message of Derived"
}

fun foo(): String = "Вызов функции foo"

fun  example(computeFoo: () -> String) {
    val memoizedFoo by lazy(computeFoo)

    if (true) {
        println(memoizedFoo)
    }
}

fun main() {
    val test = Test(10)
   println( test.l)
    println(test)
}
