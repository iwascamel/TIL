package algorithm.leetcode

class ContainsDuplicate {
    companion object{
        class Solution {
            fun containsDuplicate(nums: IntArray): Boolean {
                val set = HashSet<Int>()
                for(i in nums.indices){
                    if(set.contains(nums[i])) return true
                    set.add(nums[i])
                }
                return false
            }
        }
    }
}

fun main(){

}

