const val LIMIT_DAY = 60 * 60 * 24 // секунд в сутках

fun main() {

    print("Введите время (в секундах): ")
    val amount = readLine()!!.toInt()
    val phrase = "был(а) " + when {
                                 amount > 3 * LIMIT_DAY -> "в сети давно"
                                 amount > 2 * LIMIT_DAY -> "в сети вчера"
                                 amount >     LIMIT_DAY -> "в сети сегодня"
                                 amount >     (60 * 60) -> "в сети ${getHours(inHours = amount/3600)} назад"
                                 amount >            60 -> "в сети ${getMinutes(inMinutes = amount / 60)} назад"
                                 else -> println("в сети только что")
    }
    println(phrase)
}


fun getHours(inHours : Int): String {
    val retStr = "был(а) $inHours " +
            when(inHours) {
                1,21 -> "час"
                2,3,4,22,23,24 -> "часа"
                else -> "часов"
            }
    return retStr
}


fun getMinutes(inMinutes : Int): String {
    val retStr = "был(а) $inMinutes " +
                  when(inMinutes) {
                      1,21,31,41,51 -> "минуту"
                      2,3,4,22,23,24,32,33,34,42,43,44,52,53,54 -> "минуты"
                      else -> "минут"
                  }
    return retStr
}

