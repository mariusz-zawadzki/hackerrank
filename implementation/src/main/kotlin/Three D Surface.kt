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

// Complete the surfaceArea function below.
fun surfaceArea(A: Array<Array<Int>>, H :Int, W:Int): Int {

    var surface = 2* H*W
    A.forEach { row->
        var prev = 0
        var sum = 0
        row.forEach {
            sum += Math.abs(prev-it)
            prev = it
        }
        sum += prev
        surface +=sum
    }
    for(colIndex in 0 until W)
    {
        var sum = 0
        var prev = 0
        for(rowIndex in 0 until H){
            val it = A[rowIndex][colIndex]
            sum+=Math.abs(prev - it)
            prev = it
        }
        sum +=prev
        surface+=sum
    }
    return surface
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (H,W) = scan.nextLine().split(" ").map { it.trim().toInt() }

    val A = Array<Array<Int>>(H, { Array<Int>(W, { 0 }) })

    for (i in 0 until H) {
        A[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = surfaceArea(A, H, W)

    println(result)
}
