package algorithm.leetcode

/**
 * [Two Sum - LeetCode](https://leetcode.com/problems/two-sum/)
 * 23.03.06
* */

fun main(){
    val solution = TwoSum.Companion.Solution()
    val twoSum = solution.twoSum(intArrayOf(3, 3), 6)
    println("${twoSum[0]} + ${twoSum[1]}")
}
class TwoSum {

    companion object{
        class Solution {
            fun twoSum(nums: IntArray, target: Int): IntArray {
                // associateWith, withIndex().associateWith((index,value) -> value to index))
                val hashMap = HashMap<Int, Int>()
                for(i in nums.indices){
                    val targetHashKey = target - nums[i]
                    if(hashMap.containsKey(targetHashKey)){
                        return intArrayOf(i,hashMap[targetHashKey] ?: -1).sortedArray()
                    }
                    hashMap[nums[i]] = i
                }
                return IntArray(2)
            }
        }
    }
}