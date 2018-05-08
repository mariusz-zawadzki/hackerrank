import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val letters = scan.nextLine().split(" ").map { it.trim().toInt() }

    val letterHeights = ('a'..'z').zip(letters).toMap()
    val word = scan.nextLine()


    println(getSelectionArea(word, letterHeights))
}

fun getSelectionArea(word: String, letterHeights: Map<Char, Int>): Int {
    val map = word.toSet().map { letterHeights[it]!! }.max()!!
    return map * word.length
}
