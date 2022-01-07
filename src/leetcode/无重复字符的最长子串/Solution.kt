package leetcode.无重复字符的最长子串

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.equals("")){
            return 0
        }
        val charArray = s.toCharArray()
        var count=0
        for (index1 in 0..charArray.lastIndex){
            var temp_len=1
            val j=index1+1
            for (index2 in j..charArray.lastIndex){
                if(charArray[index1]==charArray[index2]){
                    break
                }
                temp_len++
            }
            if(temp_len>count){
                count = temp_len
            }
            temp_len=0
            if((charArray.lastIndex-index1)<temp_len){
                break
            }
        }
        return count
    }
}

fun main() {
    val str="abcabcbb"
    val test=Solution();
    val number=test.lengthOfLongestSubstring(str)
    println(number)
}