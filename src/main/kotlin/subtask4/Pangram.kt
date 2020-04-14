package subtask4

class Pangram {

    private val consonants = "bcdfghjklmnpqrstvwxz"

    private val alphabet ="abcdefghijklmnopqrstuvwxyz"
    private val vowels = "aeiouy"
    private var words = listOf<String>()

    fun getResult(inputString: String): String {
        if (inputString.trim().isEmpty())
            return ""

        words = "(\\s)+".toRegex().replace(inputString.trim(), " ").split(' ')

        return if (isPangram(inputString))
            performPangramRes()
        else
            performNotPangramRes()
    }

    private fun isPangram(string: String): Boolean {
        for (i in alphabet)
            if (!string.toLowerCase().contains(i))
                return false
        return true
    }

    private fun performPangramRes(): String {
        var letterCounter = 0
        var stringsWithNumbers = mutableListOf<Pair<String, Int>>()
        val stringBuilder = StringBuilder()
        val resultString = StringBuilder()

        for (word in words) {
            for (letter in word) {
                if (vowels.contains(letter.toLowerCase())) {
                    letterCounter++
                }
            }
            stringsWithNumbers.add(word to letterCounter)
            letterCounter = 0
        }

        stringsWithNumbers = stringsWithNumbers.sortedBy { (_, number) -> number }.toMutableList()

        for (i in stringsWithNumbers) {
            stringBuilder.append(i.second)
            for (j in i.first)
                if (vowels.contains(j))
                    stringBuilder.append(j.toUpperCase())
                else stringBuilder.append(j)

            resultString.append(stringBuilder)
            resultString.append(" ")
            stringBuilder.clear()
        }
        return resultString.trim().toString()
    }

    private fun performNotPangramRes(): String {
        var letterCnt = 0
        var stringsWithNumbers = mutableListOf<Pair<String, Int>>()

        for (word in words) {
            for (letter in word)
                if (consonants.contains(letter.toLowerCase()))
                    letterCnt++

            stringsWithNumbers.add(word to letterCnt)
            letterCnt = 0
        }

        stringsWithNumbers = stringsWithNumbers
            .sortedBy { it.second }
            .toMutableList()

        val stringBuilder = StringBuilder()
        val result = StringBuilder()

        for (i in stringsWithNumbers) {
            stringBuilder.append(i.second)
            for (j in i.first)
                if (consonants.contains(j.toLowerCase()))
                    stringBuilder.append(j.toUpperCase())
                else stringBuilder.append(j)

            result.append(stringBuilder)
            result.append(" ")
            stringBuilder.clear()
        }
        return result.trim().toString()
    }
}