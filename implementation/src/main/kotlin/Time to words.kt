import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


val mapOfHours = mapOf<Int,String>(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve"
)

val MS = " minute"
val M = " minutes"
val minutes = mapOf<Int,String>(
        0 to "o' clock",
        15 to "quarter",
        30 to "half",
        1 to "one$MS",
        2 to "two$M",
        3 to "three$M",
        4 to "four$M",
        5 to "five$M",
        6 to "six$M",
        7 to "seven$M",
        8 to "eight$M",
        9 to "nine$M",
        10 to "ten$M",
        11 to "eleven$M",
        12 to "twelve$M",
        13 to "thirteen$M",
        14 to "fourteen$M",
        16 to "sixteen$M",
        17 to "seventeen$M",
        18 to "eighteen$M",
        19 to "nineteen$M",
        20 to "twenty$M",
        21 to "twenty ${mapOfHours[1]}$M",
        22 to "twenty ${mapOfHours[2]}$M",
        23 to "twenty ${mapOfHours[3]}$M",
        24 to "twenty ${mapOfHours[4]}$M",
        25 to "twenty ${mapOfHours[5]}$M",
        26 to "twenty ${mapOfHours[6]}$M",
        27 to "twenty ${mapOfHours[7]}$M",
        28 to "twenty ${mapOfHours[8]}$M",
        29 to "twenty ${mapOfHours[9]}$M"
)
// Complete the timeInWords function below.
fun timeInWords(h: Int, m: Int): String {

    if(m == 0)
    {
        return "${mapOfHours[h]} ${minutes[m]}"
    }
    if(m <= 30){
        return  "${minutes[m]} past ${mapOfHours[h]}"
    }
    else
    {
        return  "${minutes[60-m]} to ${mapOfHours[h%12+1]}"
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val h = scan.nextLine().trim().toInt()

    val m = scan.nextLine().trim().toInt()

    val result = timeInWords(h, m)

    println(result)
}
