package validparentheses

import java.util.*
import kotlin.system.measureNanoTime
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val sol = Solution()

    measureNanoTime {
        assertEquals(true, sol.isValid("()"))
    }.let{println("첫 번재: $it")}
    measureNanoTime {
        assertEquals(true, sol.isValid2("()"))
    }.let{println("첫 번재: $it")}
    measureNanoTime {
        assertEquals(true, sol.isValid("()[]{}"))
    }.let{println("두 번재: $it")}
    measureNanoTime {
        assertEquals(false, sol.isValid("(]"))
    }.let{println("세 번재: $it")}
    measureNanoTime {
        assertEquals(true, sol.isValid("{()()()}[{()}]"))
    }.let{println("네 번재: $it")}
    measureNanoTime {
        assertEquals(true, sol.isValid2("{()()()}[{()}]"))
    }.let{println("네 번재: $it")}
    measureNanoTime {
        assertEquals(false, sol.isValid("]"))
    }.let{println("다섯 번재: $it")}
}

class Solution() {
    fun isValid(s: String): Boolean {
        var tot = 0
        var prev = mutableListOf<Int>()
        for (p in s) {
            val n = when(p) {
                '(' -> 1
                ')' -> -1
                '{' -> 2
                '}' -> -2
                '[' -> 3
                ']' -> -3
                else -> 0
            }

            if (n < 0 && prev.isEmpty()) return false

            if (n > 0) prev.add(n)
            else if (n < 0) {
                if (prev.last() + n != 0) return false
                prev.removeLast()
            }
            tot += n
        }

        return tot == 0
    }

    fun isValid2(s: String): Boolean {
        var tot = 0
        var prev = Stack<Int>()
        for (p in s) {
            val n = when(p) {
                '(' -> 1
                ')' -> -1
                '{' -> 2
                '}' -> -2
                '[' -> 3
                ']' -> -3
                else -> 0
            }

            if (n < 0 && prev.isEmpty()) return false

            if (n > 0) prev.push(n)
            else if (n < 0) {
                if (prev.peek() + n != 0) return false
                prev.pop()
            }
            tot += n
        }

        return tot == 0
    }
}