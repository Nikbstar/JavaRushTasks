package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args.length > 0) {
            if (args[0].equals("-u")) {
                Product product = new Product(args[1], args[2], args[3], args[4]);
                update(fileName, product);
            } else if (args[0].equals("-d")) {
                delete(fileName, args[1]);
            }
        }
    }

    private static void update(String fileName, Product product) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String data;
        if ((data = fis.readLine()) != null) {
            if (data.substring(0, 8).trim().equals(product.getId())) {
                sb.append(product.toString());
            } else {
                sb.append(data);
            }
        }
        while ((data = fis.readLine()) != null) {
            if (data.substring(0, 8).trim().equals(String.valueOf(product.getId()))) {
                sb.append(System.lineSeparator()).append(product.toString());
            } else {
                sb.append(System.lineSeparator()).append(data);
            }
        }
        fis.close();
        BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false)));
        fos.write(sb.toString());
        fos.close();
    }

    private static void delete(String fileName, String id) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String data;
        boolean first = true;

        while ((data = fis.readLine()) != null) {
            if (data.substring(0, 8).trim().equals(id)) {
                continue;
            }
            if (!first) {
                sb.append(System.lineSeparator());
            }
            sb.append(data);
            first = false;
        }
        fis.close();
        BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false)));
        fos.write(sb.toString());
        fos.close();
    }
}

class Product {

    private final int id;
    private final String productName;
    private final double price;
    private final int quantity;

    public Product(String id, String productName, String price, String quantity) {
        this.id = Integer.parseInt(cutString(id, 8));
        this.productName = cutString(productName, 30);
        if (price.contains(".") && price.indexOf('.') + 3 < price.length()) {
            price = price.substring(0, price.indexOf('.') + 3);
        }
        this.price = Double.parseDouble(cutString(price, 8, true));
        this.quantity = Integer.parseInt(cutString(quantity, 4));
    }

    public int getId() {
        return id;
    }

    private String cutString(String value, int saveSymbols) {
        return cutString(value, saveSymbols, false);
    }

    private String cutString(String value, int saveSymbols, boolean back) {
        if (value.length() > saveSymbols) {
            if (back) {
                value = value.substring(value.length() - saveSymbols);
            } else {
                value = value.substring(0, saveSymbols);
            }
        }
        return value;
    }

    @Override
    public String toString() {
        return String.format("%-8s%-30s%-8.2f%-4s",
                this.id, this.productName, this.price, this.quantity);
    }

}