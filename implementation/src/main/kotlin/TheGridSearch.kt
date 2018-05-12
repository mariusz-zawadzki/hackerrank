import java.util.*

// Complete the gridSearch function below.
fun gridSearch(G: Array<String>, P: Array<String>): String {

    G.forEachIndexed { rIndex, row ->
        var start = 0
        var pFoundIndex: Int
        do {
            pFoundIndex = row.indexOf(string = P[0], startIndex = start)
            start = pFoundIndex + 1
            if (pFoundIndex > -1) {
                if (rIndex + P.size <= G.size) {
                    var allMatched = true
                    P.forEachIndexed PSEARCH@{ pIndex, pRow ->
                        if (pIndex > 0) {
                            val gIndexd = G[rIndex + pIndex].substring(pFoundIndex)
                            if (gIndexd.indexOf(pRow) != 0) {
                                allMatched = false
                                return@PSEARCH
                            }
                        }
                    }
                    if (allMatched) {
                        return "YES"
                    }
                }
            }
        } while (pFoundIndex > -1)
    }
    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val (R, _) = scan.nextLine().split(" ").map { it.trim().toInt() }

        val G = Array<String>(R, { "" })
        for (i in 0 until R) {
            val GItem = scan.nextLine()
            G[i] = GItem
        }

        val (r, _) = scan.nextLine().split(" ").map { it.trim().toInt() }


        val P = Array<String>(r, { "" })
        for (i in 0 until r) {
            val PItem = scan.nextLine()
            P[i] = PItem
        }

        val result = gridSearch(G, P)

        println(result)
    }
}
