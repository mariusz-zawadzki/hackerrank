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

enum class Direction{
    N,NE,E,SE,S,SW,W,NW
}

// Complete the queensAttack function below.
fun queensAttack(n: Int, qR: Int, qC: Int, obstacles: Array<Array<Int>>): Int {

    if (n == 1)
    {
        return 0
    }

    val maxInDirection = mutableMapOf(
            Direction.N to n-qR,
            Direction.NE to Math.min(n-qR, n-qC),
            Direction.E to n-qC,
            Direction.SE to Math.min(n-qC, qR-1),
            Direction.S to qR-1,
            Direction.SW to Math.min(qR-1, qC-1),
            Direction.W to qC-1,
            Direction.NW to Math.min(n-qR, qC-1)
    )
    for(obstacle in obstacles)
    {
        val (r,c) = obstacle
        //N - S
        if(c == qC)
        {
            //N
            if(r>qR)
            {
                maxInDirection[Direction.N] = Math.min(maxInDirection[Direction.N]!!, r-qR-1)
            }
            //S
            else
            {
                maxInDirection[Direction.S] = Math.min(maxInDirection[Direction.S]!!, qR-r -1)
            }
        }
        else if (r == qR){

            //E
            if(c>qC)
            {
                maxInDirection[Direction.E] = Math.min(maxInDirection[Direction.E]!!, c-qC-1)
            }
            //W
            else
            {

                maxInDirection[Direction.W] = Math.min(maxInDirection[Direction.W]!!, qC-c -1)
            }
        }
        //same diagnal
        else {
            val cDiff = qC-c
            val rDiff = qR-r
            if (Math.abs(cDiff) == Math.abs(rDiff))
            {
                //S
                val direction = if(rDiff>0){
                    //SE
                    if(cDiff<0){
                        Direction.SE
                    }
                    //SW
                    else{
                        Direction.SW
                    }
                }
                //N
                else{
                    //NE
                    if(cDiff<0){
                        Direction.NE
                    }
                    //NW
                    else{
                        Direction.NW
                    }
                }
                maxInDirection[direction] = Math.min(maxInDirection[direction]!!, Math.abs(cDiff)-1)
            }
        }
    }

    return maxInDirection.map { it.value }.sum()

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    doLogic(scan)
}

private fun doLogic(scan: Scanner) {
    val (n, k) = scan.nextLine().split(" ").map { it.trim().toInt() }

    val (r_q, c_q) = scan.nextLine().split(" ").map { it.trim().toInt() }

    val obstacles = Array<Array<Int>>(k, { Array<Int>(2, { 0 }) })

    for (i in 0 until k) {
        obstacles[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = queensAttack(n, r_q, c_q, obstacles)

    println(result)
}
