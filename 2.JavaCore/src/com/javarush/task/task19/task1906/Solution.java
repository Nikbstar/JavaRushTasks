package com.javarush.task.task19.task1906;

/* 
Четные символы
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        reader.close();
        int data;
        boolean check = false;
        while (fileReader.ready()) {
            data = fileReader.read();
            if (check) {
                fileWriter.write(data);
            }
            check = (check) ? false : true;
        }
        fileReader.close();
        fileWriter.close();
    }
}
