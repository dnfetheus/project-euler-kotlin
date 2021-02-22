package problem

interface Problem<out T> {

    val problemName: String

    fun solve(): T

}
