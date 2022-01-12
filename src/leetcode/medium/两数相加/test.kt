/**
 * Example:
 * var  li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1==null||l2==null){
            return null
        }
        //创建返回链表
        var ret_num:ListNode?=null

        var quotient=0
        var temp_l1:ListNode?=l1
        var temp_l2:ListNode?=l2
        var temp:ListNode?=ret_num

        while (true){
            var num=0
            val sum= (temp_l1?.`val` ?: 0) + (temp_l2?.`val` ?: 0)+quotient

            if(sum>=10){
                val remainder = sum % 10
                quotient = sum / 10
                num=remainder
            }else{
                quotient=0
                num=sum
            }
            //赋值
            val value:ListNode=ListNode(num)
            if(temp!=null){
                temp.next =value
            }
            temp= value
            if(ret_num==null){
                ret_num=temp
            }

            if(temp_l1!=null){
                temp_l1= temp_l1.next
            }
            if(temp_l2!=null){
                temp_l2= temp_l2.next
            }

            //判断完成跳出循环
            if(temp_l1==null&&temp_l2==null&&quotient==0){
                break
            }
        }
        return ret_num
    }

}

fun main(args: Array<String>) {
    val test=Solution()
    val num2 =Solution.ListNode(2)
    val num3 =Solution.ListNode(3)
    val num4=Solution.ListNode(4)
    val num42=Solution.ListNode(4)
    val num5 =Solution.ListNode(5)
    val num6 =Solution.ListNode(6)

    num2.next=num4
    num4.next=num3

    num5.next=num6
    num6.next=num42
    val list=test.addTwoNumbers(num2,num5);
    var temp: Solution.ListNode?=list

    print("[")
    while (temp!=null){
        print(temp.`val`)
        temp=temp.next
        if (temp!=null){
            print(",")
        }
    }
    print("]")
}


