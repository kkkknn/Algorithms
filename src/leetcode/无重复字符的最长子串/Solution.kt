package leetcode.无重复字符的最长子串

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.equals("")){
            return 0
        }
        val charArray = s.toCharArray()
        val len=charArray.lastIndex
        var count=0
        var start=0
        var end=0
        var jump=false
        do {
            var tempCount=0
            for (index in (end+1)..len){
                for (indexJ in start..end){
                    if(charArray[indexJ]==charArray[index]){
                        println(charArray[index])
                        println(charArray[indexJ])
                        tempCount=index-start
                        start=indexJ
                        jump=true
                        count=if(tempCount>count) tempCount else count
                        break
                    }
                }
                end=index
                if(jump){
                    jump=false
                    break
                }else{
                    tempCount=(end-start)
                    count=if(tempCount>count) tempCount else count
                }
            }
            if(end==len){
                return count
            }
        }while (true)
    }
}

fun main() {
    val str="aaccc"
    val test=Solution();
    val number=test.lengthOfLongestSubstring(str)
    println(number)
}