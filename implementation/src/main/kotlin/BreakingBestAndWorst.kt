import java.util.*

/*
 * Complete the breakingRecords function below.
 */
fun breakingRecords(score: Array<Int>): Array<Int> {
    var worst = Int.MAX_VALUE
    var best = Int.MIN_VALUE
    var bestBreaks = -1
    var worstBreaks = -1

    score.forEach {
        if (it < worst) {
            worst = it
            worstBreaks++
        }
        if (it > best) {
            best = it
            bestBreaks++
        }
    }


    return arrayOf(bestBreaks, worstBreaks)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val score = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = breakingRecords(score)

    println(result.joinToString(" "))
}
