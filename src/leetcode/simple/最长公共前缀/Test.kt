package leetcode.simple.最长公共前缀

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。
输入：strs = ["flower","flow","flight"]
输出："fl"
 */
class Test {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.size==1){
            return strs[0]
        }
        var str=""
        for (i in 0 until strs[0].length){
            val temp= strs[0][i]
            for (j in 1 until strs.size){
                if( strs[j].length<=i||temp != strs[j][i]){
                    str=strs[0].substring(0,i)
                    return str
                }
            }
        }
        return strs[0]
    }
}

fun main() {
    val test=Test()
    //val arr: Array<String> = arrayOf("flower","flow","flight")
    val arr: Array<String> = arrayOf("dog","racecar","car")
    val str=test.longestCommonPrefix(arr)
    println("结果： $str")
}