package leetcode.simple.罗马数字转整数

/**
 * 罗马数字转整数
 *
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
class Solution {
    fun romanToInt(s: String): Int {
        var start = 0
        var end = 2
        var sum = 0
        if(s.length==1){
            end=1
        }
        while (true){
            val str=s.substring(start,end)
            val ret = getNum(str)
            if(ret>0){
                sum+=ret
                start=end
                end+=2
            }else{
                end--
            }
            if(start<end&&end>s.length){
                end=s.length
            }
            if(start==end){
                break
            }
        }
        return sum
    }

    fun getNum(s: String):Int{
        when(s) {
            "IV" -> return 4
            "IX" -> return 9
            "XL"-> return 40
            "XC"-> return 90
            "CD"-> return 400
            "CM"-> return 900
            "I"-> return 1
            "V"-> return 5
            "X"-> return 10
            "L"-> return 50
            "C"-> return 100
            "D"-> return 500
            "M"-> return 1000
            else -> return 0
        }
    }
}

fun main() {
    val test=Solution();
    //MCMXCIV
    val ss=test.romanToInt("I");
    println(ss)
}