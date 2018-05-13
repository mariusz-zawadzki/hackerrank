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

// Complete the almostSorted function below.
fun almostSorted(arr: List<Int>): String {

    if(arr.size == 2)
    {
        if(arr[0]<=arr[1])
        {
            return "yes"
        }
        else
        {
            return """yes
                |swap 1 2
            """.trimMargin()
        }
    }
    val swapIndex = mutableListOf<Int>()
    arr.forEachIndexed { index, element ->
        if(index>0)
        {
            if(arr[index-1] > element){
                if(swapIndex.isEmpty())
                {
                    swapIndex.add(index-1)
                }
                swapIndex.add(index)
            }
        }
    }
    if(swapIndex.size == 2){
        if(swapIndex[1]< arr.size)
        {
            if(arr[swapIndex[0]] > arr[swapIndex[1]+1] || (swapIndex[0]>0 && arr[swapIndex[0]-1]> arr[swapIndex[1]]))
            {
                return "no"
            }
        }
        return """yes
                |swap ${swapIndex[0]+1} ${swapIndex[1]+1}
            """.trimMargin()
    }
    else if(swapIndex.size > 2){
        if(swapIndex.size == 3)
        {
            val first = arr[swapIndex[0]]
            val second = arr[swapIndex[1]]
            val last = arr[swapIndex[2]]
            if(second > last)
            {
                return """
                    yes
                    swap ${swapIndex[0]+1} ${swapIndex[2]+1}
                    """.trimIndent()
            }
        }
        val indexDifference = Math.abs(swapIndex[0]-swapIndex[swapIndex.size-1])
        if(indexDifference+1 == swapIndex.size)
        {
            return """yes
                |reverse ${swapIndex[0]+1} ${swapIndex[swapIndex.size-1]+1}
            """.trimMargin()
        }
        else
        {
            return "no"
        }
    }
    else {
        return "no"
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }

    println(almostSorted(arr))
}
