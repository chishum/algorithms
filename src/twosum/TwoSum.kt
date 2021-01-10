package twosum

import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
    var sol = Solution()
    measureNanoTime {
        sol.twoSum(intArrayOf(2,7,11,15), 18).forEach { println("${it}") }
    }.let { println("첫번째 ${it}") }

    measureNanoTime {
        sol.twoSum2(intArrayOf(2,7,11,15), 18).forEach { println("${it}") }
    }.let { println("두번째 ${it}") }
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var ans = IntArray(2)
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i > j) continue
                if (nums[i] + nums[j] == target) {
                    ans[0] = i
                    ans[1] = j
                    break
                }
            }
        }

        return ans
    }

    fun twoSum2(numbs: IntArray, target: Int): IntArray {
        val scanMap = HashMap<Int, Int>()

        for (i in numbs.indices) {
            val reminder = target - numbs[i]
            if (scanMap.containsKey(reminder)) {
                return intArrayOf(i, scanMap[reminder]!!)
            }
            scanMap[numbs[i]] = i
        }
        throw IllegalArgumentException("no two sum solution")
    }
}