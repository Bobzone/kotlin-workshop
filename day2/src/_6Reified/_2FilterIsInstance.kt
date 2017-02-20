package _6Reified

fun main(args: Array<String>) {
    val anys: List<Any> =
            listOf(1, "one", 2.0)

    val strings: List<String> =
            anys.
            filterIsInstance<String>()
    /*
    The code generated by the compiler
    instead of calling inline function 'filterIsInstance':

    val destination = mutableListOf<String>()
    for (element in this) {
        if (element is String) {
            destination.add(element)
        }
    }
    val strings = destination
     */

    println(strings)
}

inline fun <reified T>
        Iterable<*>.filterIsInstance(): List<T> {

    val destination = mutableListOf<T>()
    for (element in this) {
        if (element is T) {
            destination.add(element)
        }
    }
    return destination
}