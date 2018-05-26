import java.util.*
import kotlin.collections.*

// Complete the absolutePermutation function below.
fun absolutePermutation(n: Int, k: Int): List<Int> {

    if (k == 0) {
        return (1..n).toList()
    } else if (n == 2 && k == 1) {
        return listOf(2, 1)
    } else if (n % k != 0 || (n / k) % 2 != 0) {
        return listOf(-1)
    } else {
        val result = mutableListOf<Int>()
        val limit = n / k - 1
        val dividerRange = 0..(limit) step 2
        val halfsRange = 1 downTo 0
        val stepsRange = 1..k
        for (divider in dividerRange) {
            for (half in halfsRange) {
                for (step in stepsRange) {
                    result.add(step + (divider + half) * k)
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val (n, k) = scan.nextLine().split(" ").map { it.trim().toInt() }


        val result = absolutePermutation(n, k)

        println(result.joinToString(" "))
    }
}
