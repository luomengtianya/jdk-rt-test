package com.xingquan.algorithm;


import java.util.Stack;

public class ReserveLink {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.empty()) {
            return null;
        }

        ListNode node = stack.pop();
        ListNode newHead = node;
        while (!stack.empty()) {
            ListNode temp = stack.pop();
            node.next = temp;
            node = node.next;
        }

        node.next = null;

        return newHead;
    }

    public static void main(String[] args) {

    }
}
