package extension

/**
 * Returns an iterable of mapped values until condition is not met
 *
 * @param transform function that will be used to generate the expected value
 * @param condition function that will determine when transformation needs to be stopped
 */
inline fun <T, R> Iterable<T>.mapWhile(transform: (T) -> R, condition: (R) -> Boolean): List<R> {
    val destination = ArrayList<R>()

    for (item in this) {
        val transformation = transform(item)

        when(condition(transformation)) {
            true -> destination.add(transformation)
            else -> break
        }
    }

    return destination
}
