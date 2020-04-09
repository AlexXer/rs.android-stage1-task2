package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var resIndex = 0
        var first= fibonacci(resIndex)
        var second = fibonacci(resIndex+1)
        while (first*second<n){
            resIndex++
            first=fibonacci(resIndex)
            second=fibonacci(resIndex+1)
        }
        return intArrayOf(first,second,if(first*second>n)0 else 1)
    }


    fun fibonacci(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        else{
            return (fibonacci(n-1)+fibonacci(n-2))
        }
}
}
