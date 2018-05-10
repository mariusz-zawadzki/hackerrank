import java.util.*

fun awefulTreat(n:Int, m: Int, s: Int): Int{
    val mod = (m + s - 1) % n
    return if (mod == 0 && s > 0) n else mod;
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (n) = scan.nextLine().split(" ").map { it.trim().toInt() }

    for(i in 1..n)
    {
        val (n, m, s) = scan.nextLine().split(" ").map { it.trim().toInt() }

        val result = awefulTreat(n,m,s)
        println(result)
    }


}
