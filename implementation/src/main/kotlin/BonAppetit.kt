import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)


    val (_,k) = scan.nextLine().split(" ").map { it.trim().toInt() }
    val bill = scan.nextLine().split(" ").map { it.trim().toInt() }
    val b = scan.nextLine().trim().toInt()
    val overcharge = overcharge(bill, b, k)
    val message : Any = when (overcharge) {
        0 -> "Bon Appetit"
        else -> overcharge
    }
    println(message)
}


fun overcharge(bill: List<Int>, change: Int, alergic: Int): Int
{
    return change - bill.filterIndexed {
        i, _->
          i != alergic
    }.sum()/2
}
