package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        return if (!a.toUpperCase().contains(b)) {
            var i = 0
            var j = 0
            var counter = 0

            while (i < b.length && j < a.toUpperCase().length) {
                if (b[i] == a.toUpperCase()[j]) {
                    i++
                    counter++
                }
                j++
            }
            if (counter < b.length) "NO" else "YES"
        } else "YES"
    }
}