import java.util.*

val possible = "Possible"
val impossible = "Impossible"


fun organizingContainers(container: Array<Array<Int>>): String {

    val numberOfContainersAndTypes = container.size
    val sumsByType = container.map { it.sum() }.sorted()
    val sumsByContainers = sumColumns(container, numberOfContainersAndTypes).sorted()
    return if (sumsByType.zip(sumsByContainers).all { pair ->
                pair.first == pair.second
            })
        possible
    else
        impossible
}

fun sumColumns(container: Array<Array<Int>>, n: Int): Array<Int> {

    val sums = Array(n, { 0 })
    container.forEach { ballType ->
        ballType.forEachIndexed { index, balls ->
            sums[index] += balls
        }
    }
    return sums
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val n = scan.nextLine().trim().toInt()

        val container = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            container[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        }

        val result = organizingContainers(container)

        println(result)
    }
}
