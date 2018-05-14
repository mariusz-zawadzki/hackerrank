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

// Complete the introTutorial function below.
fun introTutorial(V: Int, arr: Array<Int>): Int {
    return arr.indexOf(V)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val V = scan.nextLine().trim().toInt()

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = introTutorial(V, arr)

    println(result)
}
