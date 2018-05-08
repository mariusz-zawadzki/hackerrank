import java.util.*

/*
 * Complete the pageCount function below.
 */
fun countValeys(s: String): Int {
    var level = 0
    var valleys = 0
    s.forEach {
        when (it) {
            'U' -> {
                level++
                if (level == 0)
                    valleys++
            }
            'D' -> level--
            else -> throw IllegalArgumentException()
        }
    }
    return valleys

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val unused = scan.nextLine().trim().toInt()

    val valeys = scan.nextLine()

    val result = countValeys(valeys)

    println(result)
}
