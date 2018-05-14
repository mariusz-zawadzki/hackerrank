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

val YES = "YES"
val NO = "NO"
// Complete the larrysArray function below.
fun larrysArray(A: List<Int>): String {

    var inversions = 0
    A.forEachIndexed { index, element->
        if(index+1< A.size)
        {
            inversions += A.subList(index+1, A.size).count { it < element }
        }
    }
    return if (inversions%2 == 0) YES else NO

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val A = scan.nextLine().split(" ").map{ it.trim().toInt() }

        val result = larrysArray(A)

        println(result)
    }
}
