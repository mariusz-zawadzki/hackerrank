import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)


    val unused = scan.nextLine().trim().toInt()

    val socks = scan.nextLine().split(" ").map { it.trim().toInt() }

    print(socksMatches(socks))
}

fun socksMatches(socks: List<Int>): Int {
    return socks.groupingBy { it }.eachCount().map { it.value / 2 }.sum()
}