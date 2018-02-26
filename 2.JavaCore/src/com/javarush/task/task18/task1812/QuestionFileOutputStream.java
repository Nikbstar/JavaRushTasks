package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    final AmigoOutputStream aos;

    public QuestionFileOutputStream(AmigoOutputStream aos) {
        this.aos = aos;
    }

    @Override
    public void flush() throws IOException {
        this.aos.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.aos.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.aos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.aos.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        reader.close();
        if (answer.equals("Д")) {
            aos.close();
        }
    }
}

