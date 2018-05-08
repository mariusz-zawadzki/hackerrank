import java.util.*

/*
 * Complete the getMoneySpent function below.
 */
fun getMoneySpent(keyboards: List<Int>, drives: List<Int>, b: Int): Int {
    /*
     * Write your code here.
     */
    val keyboardsSorted = keyboards.sorted().filter { it < b }.reversed()
    val drivesSorted = drives.sorted().filter { it < b }.reversed()

    var max = -1
    keyboardsSorted.forEach keyboards@{ keyboard ->
        drivesSorted.forEach drives@{ drive ->
            val testedMax = keyboard + drive
            if (testedMax in (max + 1)..b) {
                max = testedMax
            } else {
                //no more
                return@drives
            }
        }
    }

    return max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (b, _, _) = scan.nextLine().split(" ").map { it.trim().toInt() }

    val keyboards = scan.nextLine().split(" ").map { it.trim().toInt() }

    val drives = scan.nextLine().split(" ").map { it.trim().toInt() }

    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    println(moneySpent)
}
