import java.util.*
import kotlin.collections.*

// Complete the bomberMan function below.
fun bomberMan(n: Int, grid: Array<String>): Array<String> {

    //init time:  no change
    if(n == 1)
    {
        return grid
    }
    //even are always full
    if (n % 2 == 0) {
        return grid.map { "O".repeat(it.length) }.toTypedArray()
    }

    val timeRange = 2..5
    var intGrid = getBombsCounter(grid)
    var mod3Array = Array<Array<Int>>(grid.size, { Array<Int>(grid[0].length, { -1 }) })
    var mod5Array = Array<Array<Int>>(grid.size, { Array<Int>(grid[0].length, { -1 }) })
    timeRange.forEach { tick ->
        val nextGrid = intGrid.map { it.copyOf() }.toTypedArray()
        intGrid.forEachIndexed { r, row ->
            row.forEachIndexed { c, cell ->
                if (cell in 1..tick) {
                    clear(nextGrid, r, c)
                }

                if (tick % 2 == 0) {
                    if (cell < 0) {
                        nextGrid[r][c] = tick + 3
                    }
                }
            }
        }
        intGrid = nextGrid
        when{
            tick % 4 == 3 -> mod3Array = nextGrid
            tick % 4 == 1 -> mod5Array = nextGrid
        }
    }

    return toResult(if (n % 4 == 3) mod3Array else mod5Array)
}

private fun toResult(intGrid: Array<Array<Int>>): Array<String> {
    return intGrid.map { row ->
        row.map { if (it < 0) "." else "O" }.joinToString(separator = "")
    }.toTypedArray()
}

fun clear(intGrid: Array<Array<Int>>, r: Int, c: Int) {
    clearCell(intGrid, r, c)
    clearCell(intGrid, r - 1, c)
    clearCell(intGrid, r + 1, c)
    clearCell(intGrid, r, c + 1)
    clearCell(intGrid, r, c - 1)
}

private fun clearCell(intGrid: Array<Array<Int>>, r: Int, c: Int) {
    if (r > -1 && c > -1 && r < intGrid.size && c < intGrid[r].size) {
        intGrid[r][c] = -1
    }
}

fun getBombsCounter(grid: Array<String>): Array<Array<Int>> {

    return grid.map { line ->
        line.map {
            when (it) {
                'O' -> 3
                else -> -1
            }
        }.toTypedArray()
    }.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (r, c, n) = scan.nextLine().split(" ").map { it.trim().toInt() }

    val grid = Array<String>(r, { "" })
    for (i in 0 until r) {
        val gridItem = scan.nextLine()
        grid[i] = gridItem
    }

    val result = bomberMan(n, grid)

    println(result.joinToString("\n"))
}
