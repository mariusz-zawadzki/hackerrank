import java.util.*

// Complete the migratoryBirds function below.
fun migratoryBirds(ar: List<Int>): Int {

    val pair = Pair(0, 0)
    val fold = ar.groupingBy { it }.eachCount().entries.fold(pair, { acc, entry ->

        if (acc.second < entry.value) {
            entry.toPair()
        } else if (acc.second == entry.value) {
            if (acc.first < entry.key) acc else entry.toPair()
        } else {
            acc
        }

    })
    return fold.first
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arCount = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }

    val result = migratoryBirds(ar)

    println(result)
}
