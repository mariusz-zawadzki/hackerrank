import java.util.*
import kotlin.collections.*


data class Cross(val size: Int, val r: Int, val c: Int) {
    val spread = size - 1

    val area by lazy {
        spread * 4 +1
    }

    fun overlaps(other: Cross): Boolean {


        val thisCells = (listOf(Pair(c, r)) + rowCells() + colCells()).distinct()
        val otherCells = (listOf(Pair(other.c, other.r)) + other.rowCells() + other.colCells()).distinct()
        return otherCells.find {
            thisCells.contains(it)
        } != null
    }

    fun colCells() = ((c - spread)..(c + spread)).map { Pair(it, r) }

    fun rowCells() = ((r - spread)..(r + spread)).map { Pair(c, it) }
}


// Complete the twoPluses function below.
fun twoPluses(grid: Array<Array<String>>, r: Int, c: Int): Int {

    val crossList = mutableListOf<Cross>()
    for (y in 0 until r) {
        for (x in 0 until c) {
            if (grid[y][x] != "B") {
                crossList.addAll(findCross(x, y, grid))
            }
        }
    }
    var max = 0
    for (i in 0 until crossList.size - 1) {
        val p1 = crossList.get(i)
        for (j in i + 1 until crossList.size) {
            val p2 = crossList.get(j)
            val sum = p1.area * p2.area
            if (sum > max && !p1.overlaps(p2)) {
                max = sum
            }
        }
    }
    return max

}

fun findCross(c: Int, r: Int, grid: Array<Array<String>>): List<Cross> {
    val result = mutableListOf<Cross>()

    val topR = grid.size
    val topC = grid[0].size
    var mod = 1
    var spread = mod -1
    while (
            r - spread >= 0 && isGoodCell(grid, r - spread, c) &&
            r + spread < topR && isGoodCell(grid, r + spread, c) &&
            c - spread >= 0 && isGoodCell(grid, r, c - spread) &&
            c + spread < topC && isGoodCell(grid, r, c + spread)
    ) {
        result.add(Cross(mod, r, c))
        spread = mod
        mod++
    }

    return result
}

private fun isGoodCell(grid: Array<Array<String>>, r: Int, c: Int) =
        grid[r][c] != "B"

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (n, m) = scan.nextLine().split(" ").map { it.trim().toInt() }


    val grid = Array<Array<String>>(n, { Array<String>(m, { "" }) })
    for (i in 0 until n) {
        val gridItem = scan.nextLine()
        grid[i] = gridItem.split("").filter { it != "" }.toTypedArray()
    }

    val result = twoPluses(grid, n, m)

    println(result)
}
