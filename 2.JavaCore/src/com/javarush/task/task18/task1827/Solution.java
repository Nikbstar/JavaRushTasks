package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args.length > 0) {
            if (args[0].equals("-c")) {
                Product product = new Product(generateId(fileName), args[1], args[2], args[3]);
                create(fileName, product);
            }
        }
    }

    private static void create(String fileName, Product product) throws IOException {
        if (product.getId() == 1) {
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(product.toString().getBytes());
            fos.close();
        } else {
            BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            fos.newLine();
            fos.write(product.toString());
            fos.close();
        }
    }

    private static String generateId(String fileName) {
        String result = "1";
        try (BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String data;
            while ((data = fis.readLine()) != null) {
                if (Integer.parseInt(data.substring(0, 8).trim()) > Integer.parseInt(result)) {
                    result = data.substring(0, 8).trim();
                }
            }
            result = String.format("%d", Integer.parseInt(result) + 1);
        } catch (FileNotFoundException fnfe) {
            // do nothing
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
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
