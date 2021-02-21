package problem

class Problem1 : Problem<Int> {

    override val problemName: String = "Multiples of 3 or 5"

    private val number = 1000

    override fun solve(): Int = (1 until number)
        .filter { (it % 3 == 0).or(it % 5 == 0) }
        .sum()

}
