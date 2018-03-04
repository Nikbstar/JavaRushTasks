package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        List<String> file1List = new ArrayList<>();
        List<String> file2List = new ArrayList<>();
        while (file1.ready()) {
            file1List.add(file1.readLine());
        }
        file1.close();
        while (file2.ready()) {
            file2List.add(file2.readLine());
        }
        file2.close();
        int iteratorF1 = 0;
        int iteratorF2 = 0;
        
        while (iteratorF1 < file1List.size() && iteratorF2 < file2List.size()) {
            if (file1List.get(iteratorF1).equals(file2List.get(iteratorF2))) {
                lines.add(new LineItem(Type.SAME, file1List.get(iteratorF1)));
                iteratorF1++;
                iteratorF2++;
            } else {
                boolean isEqual = false;
                for (int i = iteratorF2; i < file2List.size(); i++) {
                    if (file1List.get(iteratorF1).equals(file2List.get(i))) {
                        isEqual = true;
                        break;
                    }
                }
                if (!isEqual) {
                    lines.add(new LineItem(Type.REMOVED, file1List.get(iteratorF1)));
                    iteratorF1++;
                } else {
                    lines.add(new LineItem(Type.ADDED, file2List.get(iteratorF2)));
                    iteratorF2++;
                }
            }
            if (iteratorF1 < file1List.size() && iteratorF2 == file2List.size()) {
                lines.add(new LineItem(Type.REMOVED, file1List.get(iteratorF1)));
                iteratorF1++;
                if (iteratorF1 != file1List.size()) {
                    iteratorF2--;
                }
            }
            if (iteratorF2 < file2List.size() && iteratorF1 == file1List.size()) {
                lines.add(new LineItem(Type.ADDED, file2List.get(iteratorF2)));
                iteratorF2++;
                if (iteratorF2 != file2List.size()) {
                    iteratorF1--;
                }
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
