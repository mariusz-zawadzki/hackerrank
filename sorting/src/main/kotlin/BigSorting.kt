import java.util.*

// Complete the bigSorting function below.
fun bigSorting(unsorted: Array<String>): Array<String> {

    Arrays.sort(unsorted) { a, b ->
        val lengthCompare = a.length - b.length
        if (lengthCompare == 0)
            a.compareTo(b)
        else
            lengthCompare
    }
    return unsorted
}
//does not work, Fails test case #6 because of timeout (even with optimisiation for repeatable keys)
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    getLinesForBigSort(n, scan,{ println(it) })
}

fun getLinesForBigSort(n: Int, scan: Scanner, printer: (String)->Unit) {
    val unsorted = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val unsortedItem = scan.nextLine()
        unsorted.compute(unsortedItem) {
            _,v-> if(v==null) 1 else v+1
        }
    }

    val result = bigSorting(unsorted.keys.toTypedArray())

    result.forEach { key ->
        val n1 = unsorted[key]!!
        printer((key+"\n").repeat(n1))

    }
}
