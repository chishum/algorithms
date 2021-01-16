package longestcommonprefix

import kotlin.system.measureNanoTime
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val sol = Solution()

    measureNanoTime {
        assertEquals("fl", sol.longestCommonPrefix(arrayOf("flow","flow","flight")))
    }.let{ println("첫 번째 Case: $it")}

}

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var prefix = strs[0]

        for (i in 1 until strs.size) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length - 1)
                if (prefix.isEmpty()) return ""
            }
        }
        return prefix
    }
}