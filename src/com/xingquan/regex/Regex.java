package com.xingquan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式使用
 *
 * @author pan jianghong
 * @version 1.0.0
 * @createdate 2022/11/20 21:42
 * @description 正则表达式使用
 */
public class Regex {

    public void regexCommon() {
        String regex1 = "(1[35678][0-9])\\d{4}(\\d{4})";
        String data1 = "15376562312";

        Pattern pattern = Pattern.compile(regex1);

        Matcher matcher = pattern.matcher(data1);

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+matcher.start());
            System.out.println("end(): "+matcher.end());

            System.out.println("默认group数据: "+matcher.group());
        }

        System.out.println("替换数据: "+data1.replaceAll(regex1, "$1***$2"));


        String regex2 = "(\\d{6})\\d{8}(\\d{4})";
        String data2 = "431129199112082216";

        Pattern pattern2 = Pattern.compile(regex2);

        Matcher matcher2 = pattern.matcher(data2);

        System.out.println("替换数据: "+data2.replaceAll(regex2, "$1********$2"));



        String regex3 = "(\\S+)[ ]?[（]?(\\S?)";
        String data3 = "入账类型（plat：平台，task：任务, product : 产品）";

        Pattern pattern3 = Pattern.compile(regex2);

        Matcher matcher3 = pattern.matcher(data2);

        System.out.println("替换数据: "+data3.replaceAll(regex3, "$1 ++  $2"));

    }


    public void replaceAwardInfo() {
        String regex1 = "(.*?)\\[(.*?)\\](.*?)";
        String regex2 = "\\[(.*?)\\]";
        String source = "注册指标[潘江红]达标后队长发放";

        // 获取名称内容
        Matcher matcher = Pattern.compile(regex2).matcher(source);

        // 获取到了数据
        if (matcher.find()) {
            String name = matcher.group(1);
            source = source.replaceAll(regex1, String.format("%s%s%s%s%s", "$1", "[", name.replaceAll("(\\S)\\S(\\S*)", "$1*$2"), "]", "$3"));
        }

        System.out.println("脱敏后的数据为: " + source);
    }



    public void test() {
        String regex1 = "^\\d+.([0]+)$";
        String data1 = "123.000";

        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(data1);

       // System.out.printf(String.valueOf(matcher.find()));

        if (matcher.find()) {
            System.out.printf(data1.substring(0, data1.indexOf(".")));
        }
    }



    public void test2() {
        String regex1 = "^([a-zA-Z0-9]+)crm([a-zA-Z0-9]*.(kerlala|urthink).com)$";
        String data1 = "icbchljhdcrmvv.urthink.com";

        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(data1);


        System.out.println(String.valueOf(matcher.find()));

        System.out.println(data1.replaceAll(regex1, "$2"));
    }



    public static void main(String[] args) {
        Regex regex = new Regex();
        regex.test2();

    }
}
