import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val bars = scan.nextLine().split(" ").map { it.trim().toInt() }

    val (day, month)= scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    println(getSegmentCount(bars, day, month))
}

fun getSegmentCount(bars: List<Int>, day: Int, month: Int): Int {

    if(bars.size < month){
        return 0
    }

    var counts = 0
    for (i in 0..(bars.size-month))
    {
        var sum = 0
        for(k in i..i+month-1)
        {
            sum+= bars[k]
        }

        if(sum == day)
        {
            counts++
        }
    }

    return counts
}
