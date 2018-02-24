package com.javarush.task.task17.task1721;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> forRemoveLines = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader fileOne = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader fileTwo = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();
            String data;
            while ((data = fileOne.readLine()) != null) {
                allLines.add(data);
            }
            while ((data = fileTwo.readLine()) != null) {
                forRemoveLines.add(data);
            }
            fileOne.close();
            fileTwo.close();
            new Solution().joinData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
