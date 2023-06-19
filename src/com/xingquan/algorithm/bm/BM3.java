package com.xingquan.algorithm.bm;

import java.util.Stack;

public class BM3 {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // 1、把所有的数据分成n个K组(最后一组不满也翻转，假设是k的倍数)，然后翻转链表
        // 2、若链表不是K的倍数，则把最后一组数据再翻转一次(记录链表的大小)

        ListNode dummyNode = new ListNode(-1);

        ListNode pre = dummyNode;

        Stack<ListNode> stack = new Stack();

        while (head != null) {
            stack.push(head);

            // 移动到下一个，需要放在下面代码块之前，否则 head 就会成环了
            head = head.next;

            // k组数据满了，就翻转
            if (stack.size() == k) {
                while (!stack.empty()) {
                    pre.next = stack.pop();
                    pre = pre.next;
                    // 防止成环
                    pre.next = null;
                }
            }
        }


        ListNode cur = null;
        ListNode cur_pre = null;
        while (!stack.empty()) {
            cur_pre = stack.pop();
            cur_pre.next = cur;
            cur = cur_pre;
        }


        pre.next = cur;

        return dummyNode.next;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,1,2,3,4,5};

        ListNode dummyNode = new ListNode(nums[0]);
        ListNode pre = dummyNode;
        for (int i = 1; i < nums.length; i++) {
            pre.next = new ListNode(nums[i]);
            pre = pre.next;
        }

        BM3 bm3 = new BM3();

        ListNode n = bm3.reverseKGroup(dummyNode, 2);

        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
