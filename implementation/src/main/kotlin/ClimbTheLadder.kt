import java.util.*

/*
 * Complete the climbingLeaderboard function below.
 */
fun climbingLeaderboard(scores: List<Int>, alice: List<Int>): List<Int> {

    val sortedScores = scores.toSet().toList().asReversed()
    var currentPlace = sortedScores.size+1
    var currentIndex = 0

    return alice.map { aliceScore ->
            while (currentIndex < sortedScores.size && sortedScores[currentIndex] <= aliceScore) {
                currentIndex++
                currentPlace--
            }
        currentPlace
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map{ it.trim().toInt() }

    val aliceCount = scan.nextLine().trim().toInt()

    val alice = scan.nextLine().split(" ").map{ it.trim().toInt() }

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}
