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

// Complete the encryption function below.
fun encryption(s: String): String {

    val stripped = s.replace(" ", "")

    val sqrt = Math.sqrt(stripped.length.toDouble())
    val cols = Math.ceil(sqrt).toInt()
    val rows = Math.round(sqrt).toInt()

    val result = Array(cols, { StringBuilder() })
    for (i in 0 until cols) {
        for(row in 0 until rows){
            val position = row * cols + i
            if(position < stripped.length){
                result[i].append(stripped[position])
            }
        }
    }

    return result.map {
        it.toString()
    }.joinToString(" ")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = encryption(s)

    println(result)
}
