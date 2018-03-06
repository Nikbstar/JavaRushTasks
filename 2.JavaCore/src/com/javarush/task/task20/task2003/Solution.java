package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            load(new FileInputStream(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        pr.putAll(properties);
        pr.store(outputStream, "Solution");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        pr.load(inputStream);
        for (Map.Entry<Object, Object> entry : pr.entrySet()) {
            properties.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
    }
}
