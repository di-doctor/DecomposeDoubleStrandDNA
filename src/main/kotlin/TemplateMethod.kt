fun main() {
    println(A().executeTemplate())
    println(B().executeTemplate())
}

class A(): TemplateClass(){
    override fun diff() {
        println("Peace")
    }

    override fun diff2(): String {
       return "End My message"
    }
}
class B(): TemplateClass(){
    override fun diff() {
        println("House")
    }

    override fun diff2(): String {
        return "message have been ended"
    }
}
abstract class TemplateClass(){
    fun executeTemplate(): String{
        println("Hello")
        println("World")
        println("My")
        diff()
        return diff2()
    }
    abstract fun diff()
    abstract fun diff2(): String
}