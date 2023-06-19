package com.xingquan.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * 排序
 *
 * @author pan jianghong
 * @version 1.0.0
 * @createdate 2022/12/1 15:24
 * @description 排序
 */
public class Sort {


    public static void main(String[] args) {
        Map<String, String> data = new TreeMap<>();
        data.put("noce", "dfasdfas");
        data.put("appId", "dadfsdfs");
        data.put("SJHM", "34234");


        StringBuffer sb = new StringBuffer();
        data.forEach((k,v) -> sb.append(k).append("=").append(v).append("&"));
        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb.toString());


        System.out.printf(String.valueOf(System.currentTimeMillis() - 1669963161045l));

    }
}
