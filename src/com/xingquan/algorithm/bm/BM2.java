package com.xingquan.algorithm.bm;

public class BM2 {

    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {

        /*
         *  思路：
         *      把链表分成三个部分 left + reserve + right
         *      然后再用一个虚拟节点把这几个部分链接起来
         *  left: 待翻转的链表左边一个元素
         *  pre: 待翻转元素的前一个元素
         *  cur: 当前待翻转元素
         */

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;


        // 先把left的数据添加上 移动 n-1 前的数据
        for (int i = 1; i < m - 1; i++) {
            head = head.next;
        }

        // 循环前的一个元素
        ListNode left = head;
        ListNode move = head.next;
        ListNode move_next = null;

        // 再把reserve数据链接 可以把翻转看成贪吃蛇，头部向前开，吃一个就把其放到尾部
        for (int i = 0; i < n - m; i++) {
            move_next = move.next;
            move.next = move_next.next;
            move_next.next = left.next;
            left.next = move_next;
        }

        return dummyNode.next;
    }
}
