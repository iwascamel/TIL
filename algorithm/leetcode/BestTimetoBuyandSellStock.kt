package algorithm.leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 23.03.12
 */

fun main(){
    val solution = BestTimetoBuyandSellStock.Companion.Solution()
    val maxProfit = solution.maxProfit(intArrayOf(7,6,4,3,1))
    println(maxProfit)
}

class BestTimetoBuyandSellStock {

    companion object{
        class Solution {
            fun maxProfit(prices: IntArray): Int {
                var minValue = Int.MAX_VALUE
                var maxProfit = 0
                for(price in prices){
                    if(price > minValue){
                        maxProfit = max(maxProfit, price - minValue)
                    }else{
                        minValue = price
                    }
                }
                return maxProfit
            }
        }
    }
}