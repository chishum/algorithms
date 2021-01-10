package integertoroman

import kotlin.system.measureNanoTime
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    /*
    println(4326 / 1 % 10);
    println(4321 / 10 % 10);
    println(4321 / 100 % 10);
    println(4321 / 1000 % 10);
    */

    val sol = Solution()

    measureNanoTime {
        assertEquals("MMMCCCXXI", sol.intToRoman(3321))
    }.let { println("1번 case: ${it}") }

    measureNanoTime {
        assertEquals("MMMCCCXXI", sol.intToRoman2(3321))
    }.let { println("1번 case: ${it}") }

}

class Solution {
    private val roman = mapOf(1 to "I", 5 to "V", 10 to "X", 50 to "L", 100 to "C", 500 to "D", 1000 to "M")

    fun intToRoman(num: Int): String {
        val a = convert(num / 1 % 10, 1)
            .map { roman[it] }
            .joinToString(separator = "")
        val b = convert(num / 10 % 10, 10)
            .map { roman[it] }
            .joinToString(separator = "")
        val c = convert(num / 100 % 10, 100)
            .map { roman[it] }
            .joinToString(separator = "")
        val d = convert(num / 1000 % 10, 1000)
            .map { roman[it] }
            .joinToString(separator = "")
        return d+c+b+a
    }

    private fun convert(n: Int, m: Int) = when (n) {
        1 -> intArrayOf(1 * m)
        2 -> intArrayOf(1 * m,1 * m)
        3 -> intArrayOf(1 * m,1 * m,1 * m)
        4 -> intArrayOf(1 * m,5 * m)
        5 -> intArrayOf(5 * m)
        6 -> intArrayOf(5 * m,1 * m)
        7 -> intArrayOf(5 * m,1 * m,1 * m)
        8 -> intArrayOf(5 * m,1 * m,1 * m,1 * m)
        9 -> intArrayOf(1 * m,10 * m)
        else -> intArrayOf()
    }

    fun intToRoman2(num: Int): String {
        var nbr = num
        var i = 0
        var ans = ""
        var array1 = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        var array2 = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        while(i < array1.size && nbr > 0) {
            if (array1[i] <= nbr) {
                nbr -= array1[i]
                ans += array2[i]
            }
            else {
                i++
            }
        }
        return ans;
    }
}