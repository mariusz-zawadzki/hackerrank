import java.util.*
import kotlin.collections.*

// Complete the prims function below.
fun prims(edges: Array<Array<Int>>, start: Int): Int {

    val edgeMap = Multimap()
    edges.forEach {
        edgeMap.putSingle(it[0], Pair(it[1], it[2]))
        edgeMap.putSingle(it[1], Pair(it[0], it[2]))
    }
    var sum = 0
    val usedNodes = mutableListOf<Int>(start)
    val nodesLeft = HashSet(edgeMap.keys)
    nodesLeft.remove(start)
    val allowedMap = Multimap()
    allowedMap.put(start, edgeMap[start])
    while (nodesLeft.isNotEmpty())
    {
        val shortestEdge = allowedMap.flatMap { it.value }.filter { !usedNodes.contains(it.first) }.minBy { it.second }
        if(shortestEdge==null)
        {
            return sum
        }
        else
        {
            sum+=shortestEdge.second
            usedNodes.add(shortestEdge.first)
            allowedMap.put(shortestEdge.first, edgeMap[shortestEdge.first])
        }

    }
    return sum
}

class Multimap: HashMap<Int, MutableList<Pair<Int, Int>>>() {

    override operator fun get(key:Int ): MutableList<Pair<Int,Int>>{
        val get = super.get(key)
        if (get == null){
            this[key] = mutableListOf()
        }
        return super.get(key)!!
    }

    fun putSingle(key:Int, value: Pair<Int,Int>){
        this[key].add(value)
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val result = primsFullInput(scan)

    println(result)
}

fun primsFullInput(scan: Scanner): Int {
    val (_, m) = scan.nextLine().split(" ").map { it.trim().toInt() }


    val edges = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        edges[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val start = scan.nextLine().trim().toInt()

    val result = prims(edges, start)
    return result
}
