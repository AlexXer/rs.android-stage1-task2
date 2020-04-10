package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {


    fun toTextDay(day: String, month: String, year: String): String {
        var res = ""
        try {
            val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            res = date.format(DateTimeFormatter.ofPattern("dd MMMM, EEEE", Locale.forLanguageTag("ru")))
        }catch (ex:DateTimeException){
            res = "Такого дня не существует"
        }
        return res
    }
}
