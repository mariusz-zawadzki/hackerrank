import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val numbers = scan.nextLine().split(" ").map { it.trim().toInt() }

    println(findLongestMinimalSubset(numbers))
}

fun findLongestMinimalSubset(numbers: List<Int>): Int {
    val counts = numbers.groupingBy { it }.eachCount()
    val maxCount = counts.values.max()!!
    var previous = 0
    if (counts.size==1){
        return maxCount
    }
    var max = counts.keys.toList().sorted().map {
        if (previous != 0) {
            if (it - previous == 1) {
                return@map Pair(previous, it)
            }
        }
        previous = it
        Pair(0, it)
    }
            .filter { it.first != 0 }
            .map { counts[it.first]!! + counts[it.second]!! }
            .max()
    if(max == null){
        max = maxCount
    }
    return Math.max(max,maxCount)
}
