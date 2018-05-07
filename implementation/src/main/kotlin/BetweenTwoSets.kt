import java.util.*

private fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)


/*
 * Complete the getTotalX function below.
 */
fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    /*
     * Write your code here.
     */

    val minGCD = findMinDivider(b)

    val allList= mutableSetOf<Int>()
    a.forEach {
        for (i in 1..minGCD/it) {
            allList.add(it*i)
        }
    }
    val size = allList.filter {
        a.all { divisor->
            it%divisor==0
        }
    }.filter {
        b.all { divisor->
            divisor%it==0
        }
    }.size

    return size
}

private fun <E> List<E>.tail() =
        if (this.size > 1) {
            this.subList(1, this.size )
        } else {
            listOf<E>()
        }

fun findMinDivider(a: Array<Int>): Int {

    val sortedArray = a.sorted()
    val (first) = sortedArray
    val subList = sortedArray.tail()
    val map = subList.map { gcd(it, first) }
    return map.min()?:first

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val b = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val total = getTotalX(a, b)

    println(total)
}
