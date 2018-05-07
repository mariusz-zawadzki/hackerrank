import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (_, k)= scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val numbers = scan.nextLine().split(" ").map { it.trim().toInt() }


    println(countDivisiblePairs(numbers, k))
}

fun countDivisiblePairs(numbers: List<Int>, k: Int): Int {

    return numbers.mapIndexed {
        i,it->
        val countDivisors = countDivisors(numbers.subList(i+1, numbers.size), it, k)
        countDivisors
    }.sum()
}

fun countDivisors(numbers: List<Int>, n: Int, k: Int): Int {
    return numbers.filter {
        (it+n) % k == 0
    }.size
}
