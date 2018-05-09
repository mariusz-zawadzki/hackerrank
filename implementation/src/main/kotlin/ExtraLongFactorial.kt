import java.math.BigInteger
import java.util.*


private operator fun BigInteger.times(i: Int): BigInteger = this.multiply(BigInteger.valueOf(i.toLong()))

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val (n) = scan.nextLine().split(" ").map { it.trim().toInt() }
    print(bigFactorial(n))
}

fun bigFactorial(n: Int): BigInteger {
    var factorial = BigInteger.ONE
    for (i in 1..n) {
        factorial *= i
    }
    return factorial
}