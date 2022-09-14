package leetcode.simple.删除某些元素后的数组均值

/**
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。

与 标准答案 误差在 10-5 的结果都被视为正确结果。

 

示例 1：

输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
输出：2.00000
解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
示例 2：

输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
输出：4.00000

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/mean-of-array-after-removing-some-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Test {
    //思路：先排序，然后找到起止位置，进行遍历添加，返回结果
    fun trimMean(arr: IntArray): Double {
        //选择排序
        val len = arr.size
        var thisIndex: Int
        var temp: Int
        for (i in 1 until len) {
            thisIndex = i - 1
            temp = arr[i]
            while (thisIndex >= 0 && arr[thisIndex] > temp) {
                arr[thisIndex + 1] = arr[thisIndex]
                thisIndex--
            }
            arr[thisIndex + 1] = temp
        }
       //获取5%的位置

        val delSize=arr.size*0.05;
        val start=delSize.toInt()
        val end=(arr.size-delSize).toInt()-1
        val retLen=(arr.size-(delSize*2))
        var sum=0
        println("size $delSize")
        for (i in start..end){
            sum+=arr[i]
        }
        println("sum $sum")
        println("retLen $retLen")
        return sum/retLen

    }

    fun test(arr: IntArray): Double{
        var sum=0
        for (element in arr){
            sum+=element
        }
        sum-=4

        return  (sum.toDouble()/(arr.size-2))
    }

}

fun main(){
    val arr: IntArray = intArrayOf(6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4)
    //val arr: IntArray = intArrayOf(6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0)
    //val arr: IntArray = intArrayOf(1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3)

    val test= Test()
    val str=test.trimMean(arr)
    val str2 =test.test(arr)
    println(str)
    println(str2)
}