package com.xingquan.string;

public class StringTest {


    public void Test1() {
        String aa = "abc";
        String bb = new String("abc");
        String cc = new StringBuffer("abc").toString();
        String dd = "abc";

        System.out.println(aa == bb );
        System.out.println(aa == cc );
        System.out.println(bb == cc );
        System.out.println(bb == dd );
        System.out.println(aa == dd );
    }


    public void Test2() {
        String aa = new String("ab") + new String("cd");
    }

    public static void main(String[] args) {


    }
}
