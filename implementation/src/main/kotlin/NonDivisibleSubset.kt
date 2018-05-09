import java.util.*

/*
 * Complete the nonDivisibleSubset function below.
 */
fun nonDivisibleSubset(k: Int, S: List<Int>): Int {
    val filtered = S.filter { it % k != 0 }
    val extras = if (S.size - filtered.size > 0) 1 else 0

    val eachCount = filtered
            .groupingBy { it % k }
            .eachCount()

    var count = extras
    for (i in 1..(k/2)){
        if(i == k-i)
        {
            count+=1
        }
        else
        {
            count += Math.max(eachCount[i]?:0, eachCount[k-i]?:0)
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (_, k) = scan.nextLine().split(" ").map { it.trim().toInt() }

    val S = scan.nextLine().split(" ").map { it.trim().toInt() }

    val result = nonDivisibleSubset(k, S)

    println(result)
}
