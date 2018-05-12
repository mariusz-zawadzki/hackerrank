import java.util.*
fun biggerIsGreater(w: String): String {
    var toList = w.toMutableList()

    if(toList.size == 2)
    {
        toList.reverse()
    }
    else
    {
        for(i in toList.size-1 downTo 1 )
        {
            val currentIndex = i - 1
            val currentChar = toList[currentIndex]
            //first non decreasing
            if(toList[i] > currentChar)
            {
                //all after current
                val soretedAfter = toList.subList(currentIndex, toList.size)
                        .sorted()
                //first greater than current
                val firstGreater = soretedAfter.first { it > currentChar }

                val resList = toList.subList(0, currentIndex).toMutableList()
                resList.add(firstGreater)
                val toMutableList = soretedAfter.toMutableList()
                toMutableList.remove(firstGreater)
                resList.addAll(toMutableList)
                toList = resList
                break

            }
        }
    }
    val result = toList.joinToString("")
    return if(result <= w) "no answer" else result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val T = scan.nextLine().trim().toInt()

    repeat(T) {
        val w = scan.nextLine()

        val result = biggerIsGreater(w)

        println(result)
    }
}
