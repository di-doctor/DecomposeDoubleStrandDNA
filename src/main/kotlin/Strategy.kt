fun sum(x: Int, y: Int): Int {
    return x + y
}

fun sumOne(x: Int): (Int) -> (Int) -> Int {
    return { y: Int ->
        { z: Int -> x + y + z }
    }
}

fun main() {
    println(sum(3, 5))
    println(sumOne(3)(5)(4))

}

interface Strategy {
    fun execute(a: Int, b: Int): Int
}

class Add() : Strategy {
    override fun execute(a: Int, b: Int): Int {
        return a + b
    }
}

class Multiply() : Strategy {
    override fun execute(a: Int, b: Int): Int {
        return a * b
    }
}

class Contex(var strategy: Strategy) {
    fun executeStrategy(a: Int, b: Int): Int {
        return strategy.execute(a, b)
    }
}