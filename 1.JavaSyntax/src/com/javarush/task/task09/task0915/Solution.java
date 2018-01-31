package com.javarush.task.task09.task0915;

import java.io.CharConversionException;
import java.nio.file.FileSystemException;
import java.io.IOException;
/* 
Перехват выборочных исключений
*/

public class Solution {
    public static StatelessBean BEAN = new StatelessBean();

    public static void main(String[] args) {
        try {
            processExceptions();
        } catch (FileSystemException fse) {
            BEAN.log(fse);
        }
    }

    public static void processExceptions() throws FileSystemException {
        try {
            BEAN.methodThrowExceptions();
        } catch (FileSystemException fse) {
            BEAN.log(fse);
            throw fse;
        } catch (CharConversionException cce) {
            BEAN.log(cce);
        } catch (IOException ioe) {
            BEAN.log(ioe);
        }
    }

    public static class StatelessBean {
        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws CharConversionException, FileSystemException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0)
                throw new CharConversionException();
            if (i == 1)
                throw new FileSystemException("");
            if (i == 2)
                throw new IOException();
        }
    }
}
