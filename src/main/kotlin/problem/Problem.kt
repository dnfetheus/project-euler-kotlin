package problem

interface Problem<out T : Any> {

    val problemName: String

    fun solve(): T

}
