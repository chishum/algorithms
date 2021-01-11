package reverseinteger

import java.lang.Exception
import kotlin.system.measureNanoTime
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val sol = Solution()

    measureNanoTime {
        assertEquals(-646324351, sol.reverse(-153423646))
    }.let{println("첫번째 : $it")}

    measureNanoTime {
        assertEquals(-646324351, sol.reverse2(-153423646))
    }.let{println("두번째 : $it")}
}

class Solution {
    fun reverse(x: Int): Int {
        try {
            if (x < 0) {
                return x.times(-1).toString().reversed().toInt() * -1
            } else {
                return x.toString().reversed().toInt()
            }
        }
        catch (e: Exception){
            return 0
        }
    }

    fun reverse2(x : Int): Int {
        var current = x
        var digit = 0
        var result = 0

        while (current != 0) {
            digit = current % 10
            current /= 10
            result = result * 10 + digit
        }

        return result
    }
}