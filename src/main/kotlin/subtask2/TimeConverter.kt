package subtask2

class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        val minutes = minute.toInt()
        val hours = hour.toInt()
        val map = mapOf<Int, String>(
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine",
            10 to "ten",
            11 to "eleven",
            12 to "twelve",
            13 to "thirteen",
            14 to "fourteen",
            15 to "quarter",
            16 to "sixteen",
            17 to "seventeen",
            18 to "eighteen",
            19 to "nineteen",
            20 to "twenty",
            21 to "twenty one",
            22 to "twenty two",
            23 to "twenty three",
            24 to "twenty four",
            25 to "twenty five",
            26 to "twenty six",
            27 to "twenty seven",
            28 to "twenty eight",
            29 to "twenty nine",
            30 to "half")

            var res =""
        if (hour.toInt() in 0..11 && minute.toInt() >= 0 && minute.toInt() <= 60) {
            res = when(minutes){
                0-> "${map.getValue(hours)} o' clock"
                1-> "${map.getValue(minutes)} minute past ${map.getValue(hours)}"
                in 2..14 -> "${map.getValue(minutes)} minutes past ${map.getValue(hours)}"
                15-> "${map.getValue(minutes)} past ${map.getValue(hours)}"
                in 16..29 -> "${map.getValue(minutes)} minutes past ${map.getValue(hours)}"
                30-> "${map.getValue(minutes)} past ${map.getValue(hours)}"
                45-> "${map.getValue(60-minutes)} to ${map.getValue((hours+1)%12)}"
                else -> "${map.getValue(60-minutes)} minutes to ${map.getValue((hours+1)%12)}"
            }

        }
        return res
    }
}
