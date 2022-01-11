package leetcode.无重复字符的最长子串

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        s.replace(" ","")
        if(s == ""){
            return 0
        }
        if(s.length==1){
            return s.length
        }
        val charArray = s.toCharArray()
        val len=charArray.lastIndex
        var count=0
        var start=0
        var end=0
        var jump=false
        var index=end+1
        do {
            var tempCount=0
            for (indexJ in start..end){
                if(charArray[indexJ]==charArray[index]){
                    tempCount=end-start
                    start=indexJ+1
                    jump=true
                    break
                }
            }
            if(jump){
                if((len-count)<count){
                    return count+1
                }
                jump=false
            }else{
                tempCount=(index-start)
            }
            end=index++
            count=if(tempCount>count) tempCount else count

            if(end==len){
                return count+1
            }

        }while (true)
    }
}

fun main() {
    val str="abvvc"
    val test=Solution();
    val number=test.lengthOfLongestSubstring(str)
    println(number)
}