package com.xingquan.gc;

/**
 * 运行时添加 vm options -XX:+PrintGCDetails 可以打印出GC相关情况
 */
public class Gc1 {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];

        allocation2 = new byte[900*1024];
    }
}
