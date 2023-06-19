package com.xingquan.algorithm;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[] nums = new int[num];

        int i = 0;
        while (in.hasNext()) {
            nums[i++] = in.nextInt();
            if (i == num) {
                in.close();
            }
        }

        System.out.println(nums);
    }
}
