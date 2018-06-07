package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            if (params.get(key) ==null) {
                continue;
            }
            sb.append(key).append(" = '");
            sb.append(params.get(key)).append("' and ");
        }
        if (sb.length() > 4) {
            sb.delete(sb.length() - 5, sb.length());
        }
        return sb.toString();
    }
}
