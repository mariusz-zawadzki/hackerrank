import java.util.*
import kotlin.io.*

class Sherlock {

    fun isValid(s: String): String {

        val groupBy = s.toList()
                .groupBy { it } //group by characters
                .map { it.value.size } //translate to character count
                .groupBy { it } //group by count
        return when (isValidCharacterGroup(groupBy)) {
            true -> "YES"
            false -> "NO"
        }
    }

    private fun isValidCharacterGroup(groupBy: Map<Int, List<Int>>) =
            groupBy.size == 1 || hasOnlyOneOffCharacter(groupBy) || hasOnlyOneMore(groupBy)

    private fun hasOnlyOneMore(groupBy: Map<Int, List<Int>>): Boolean {
        val onlyTwoGroups = groupBy.size == 2
        return if (onlyTwoGroups) {
            val max = groupBy.keys.max()!!
            val min = groupBy.keys.min()!!
            groupBy[max]!!.size == 1 && max-min == 1
        } else
            false
    }

    private fun hasOnlyOneOffCharacter(groupBy: Map<Int, List<Int>>): Boolean {
        val onlySingle = groupBy[1]
        return groupBy.size == 2 && onlySingle != null && onlySingle.size == 1
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = Sherlock().isValid(s)

    println(result)
}
