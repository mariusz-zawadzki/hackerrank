import java.util.*

/*
 * Complete the climbingLeaderboard function below.
 */
fun getHurdleDiff(heights: List<Int>, maxJump:Int): Int {

    return Math.max(0,heights.max()!!-maxJump)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)


    val (_, k) = scan.nextLine().split(" ").map{ it.trim().toInt() }

    val heights = scan.nextLine().split(" ").map{ it.trim().toInt() }

    val result = getHurdleDiff(heights, k)

    println(result)
}
