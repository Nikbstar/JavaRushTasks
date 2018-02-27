package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        while (true) {
            try (FileInputStream fis = new FileInputStream(fileName = reader.readLine())) {
            } catch (FileNotFoundException fnfe) {
                System.out.println(fileName);
                break;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
