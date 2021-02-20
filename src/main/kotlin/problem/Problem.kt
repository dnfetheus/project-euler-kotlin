package problem

interface Problem<T> {

    val problemName: String

    fun solve(): T

}
