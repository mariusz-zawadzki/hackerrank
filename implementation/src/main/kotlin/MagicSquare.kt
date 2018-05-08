import java.util.*


fun magicSquares(): List<Triple<Triple<Int, Int, Int>, Triple<Int, Int, Int>, Triple<Int, Int, Int>>> {

    val potentialRows = mutableSetOf<Triple<Int, Int, Int>>()

    for (i in 1..9) {
        for (j in 1..9) {
            for (k in 1..9) {
                if (isCorrectRow(i, j, k)) {
                    potentialRows.add(Triple(i, j, k))
                }
            }
        }
    }
    val magicSquares = mutableListOf<Triple<Triple<Int, Int, Int>, Triple<Int, Int, Int>, Triple<Int, Int, Int>>>()
    potentialRows.forEach { row1 ->
        potentialRows.forEach { row2 ->
            potentialRows.forEach { row3 ->
                if (
                        allIntsDifferent(row1, row2, row3)
                        &&
                        isCorrectRow(row1.first, row2.first, row3.first)
                        &&
                        isCorrectRow(row1.second, row2.second, row3.second)
                        &&
                        isCorrectRow(row1.third, row2.third, row3.third)
                        &&
                        isCorrectRow(row1.first, row2.second, row3.third)
                        &&
                        isCorrectRow(row1.third, row2.second, row3.first)
                )
                    magicSquares.add(Triple(row1, row2, row3))
            }
        }
    }

    return magicSquares
}

fun allIntsDifferent(row1: Triple<Int, Int, Int>, row2: Triple<Int, Int, Int>, row3: Triple<Int, Int, Int>): Boolean {
    val mutableSet = row1.toList().toMutableSet()
    mutableSet.addAll(row2.toList())
    mutableSet.addAll(row3.toList())
    return mutableSet.size == 9
}

private fun isCorrectRow(i: Int, j: Int, k: Int) = i + j + k == 15


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val row1 = scan.nextLine().split(" ").map { it.trim().toInt() }
    val row2 = scan.nextLine().split(" ").map { it.trim().toInt() }
    val row3 = scan.nextLine().split(" ").map { it.trim().toInt() }

//    Triple
    println(getMinDifference(listOf(row1,row2, row3).flatMap { it }))
}

fun getMinDifference(expectedTriple: List<Int>): Int? {
    val expected = expectedTriple
    return allMagicSquares.map {
        val flatMap = it.toList().flatMap { it.toList() }
        flatMap.zip(expected) { a, b ->
            Math.abs(a - b)
        }.sum()
    }.min()
}


val allMagicSquares = listOf(
        Triple(
                Triple(2, 7, 6),
                Triple(9, 5, 1),
                Triple(4, 3, 8))
        ,
        Triple(
                Triple(2, 9, 4),
                Triple(7, 5, 3),
                Triple(6, 1, 8))
        ,
        Triple(
                Triple(4, 3, 8),
                Triple(9, 5, 1),
                Triple(2, 7, 6))
        ,
        Triple(
                Triple(4, 9, 2),
                Triple(3, 5, 7),
                Triple(8, 1, 6))
        ,
        Triple(
                Triple(6, 1, 8),
                Triple(7, 5, 3),
                Triple(2, 9, 4))
        ,
        Triple(
                Triple(6, 7, 2),
                Triple(1, 5, 9),
                Triple(8, 3, 4))
        ,
        Triple(
                Triple(8, 1, 6),
                Triple(3, 5, 7),
                Triple(4, 9, 2))
        ,
        Triple(
                Triple(8, 3, 4),
                Triple(1, 5, 9),
                Triple(6, 7, 2))
)