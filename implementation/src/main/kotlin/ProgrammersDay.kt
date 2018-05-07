import java.time.LocalDate
import java.util.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val year = scan.nextLine().trim().toInt()

    val programmersDate = getProgrammersDayDate(year)
    println(programmersDate)
}

fun getProgrammersDayDate(year: Int): String {
    val dayModifier =
            if (year == 1918) {
                +13
            } else if (year < 1918 && year % 100 == 0) {
                -1
            } else {
                0
            }
    //use gregorian calendar shifted a bit according to year
    val ofYearDay = LocalDate.ofYearDay(year, 256+dayModifier)


    return "%02d.%02d.%04d".format(ofYearDay.dayOfMonth,ofYearDay.month.value,ofYearDay.year)
}
