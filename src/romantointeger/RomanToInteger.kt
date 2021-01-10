package romantointeger

import kotlin.system.measureNanoTime
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val sol = Solution()

    measureNanoTime {
        assertEquals(1884, sol.romanToInt("MDCCCLXXXIV"))
    }.let{println("첫 번째: $it")}

    measureNanoTime {
        assertEquals(1884, sol.romanToInt2("MDCCCLXXXIV"))
    }.let{println("두 번째: $it")}
}

class Solution() {
    fun romanToInt(s: String): Int {
        val roman = mapOf("M" to 1000, "CM" to 900, "D" to 500, "CD" to 400, "C" to 100, "XC" to 90, "L" to 50, "XL" to 40, "X" to 10, "IX" to 9, "V" to 5, "IV" to 4, "I" to 1)
        var ans = 0
        var i = 0
        while (i < s.length) {
            if (i + 2 <= s.length && roman[s.substring(i,i+2)] != null) {
                ans += roman[s.substring(i,i+2)]!!
                i += 2
            }
            else {
                ans += roman[s[i].toString()]!!
                i++
            }
        }

        return ans
    }

    fun romanToInt2(s: String): Int {
        var currentInt = 0
        var prevInt = 0
        var ans = 0

        for (i in s.length - 1 downTo 0) {
            when (s[i]) {
                'M' -> currentInt = 1000
                'D' -> currentInt = 500
                'C' -> currentInt = 100
                'L' -> currentInt = 50
                'X' -> currentInt = 10
                'V' -> currentInt = 5
                'I' -> currentInt = 1
            }

            if (currentInt >= prevInt) {
                ans += currentInt
            }
            else {
                ans -= currentInt
            }

            prevInt = currentInt
        }

        return ans
    }
}