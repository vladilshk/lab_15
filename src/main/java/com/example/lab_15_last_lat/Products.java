package com.example.lab_15_last_lat;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Products {
    private Map<Integer, Product> productMap;
    private int ID;

    public Products() throws IOException {
        ID = 0;
        getData();
    }

    public void addProduct(String name, String author, String description, int price) {
        ID++;
        Product product = new Product(name, author, description, price, ID);
        productMap.put(product.getId(), product);
    }

    public Product getProduct(int id) {
        return productMap.get(id);
    }

    public Map<Integer, Product> getAllBooks() {
        return productMap;
    }


    public void setData() throws IOException {
        FileWriter fileWriter = new FileWriter("products.txt");
        for (Product product : productMap.values()) {
            fileWriter.write(product.getName() + "\n");
            fileWriter.write(product.getAuthor() + "\n");
            fileWriter.write(product.getDescription() + "\n");
            fileWriter.write(product.getPrice() + "\n");
            fileWriter.write(product.getId() + "\n");
        }
        fileWriter.close();
    }

    public void getData() throws IOException {
        Path path = Paths.get("products.txt");
        Scanner scanner = new Scanner(path);

        int idx = 0;
        productMap = new HashMap<>();
        while (scanner.hasNextLine()){
            Product product = new Product();
            product.setName(scanner.nextLine());
            product.setAuthor(scanner.nextLine());
            product.setDescription(scanner.nextLine());
            product.setPrice( Integer.parseInt(scanner.nextLine()));
            product.setId( Integer.parseInt(scanner.nextLine()));
            ID = product.getId();
            productMap.put(product.getId(), product);
        }

    }

    public String getBooksForPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table>");
        for (int i = 0; i < 4; i++) {
            stringBuilder.append("<tr>");
            for (int j = 0; j < 4; j++) {
                if (productMap.containsKey(i * 4 + j)) {
                    stringBuilder.append("<td>");
                    stringBuilder.append("<img src=\"book.png\" width=\"250\" height=\"250\">");
                    stringBuilder.append("<h4>" + productMap.get(i * 4 + j).getName() + "<h4>");
                    stringBuilder.append("<h4>Price:" + productMap.get(i * 4 + j).getPrice() + "</h4>");
                    stringBuilder.append("<form action=\"ProductServlet\" method=\"get\">\n");
                    stringBuilder.append("<input type=\"hidden\" name=\"id\" value=\"" + (i * 4 + j) + "\">");
                    stringBuilder.append("<input type=\"submit\" value=\"more info\" >");
                    stringBuilder.append("</form>");
                    stringBuilder.append("</td>");
                } else {
                    stringBuilder.append("<td>");
                    stringBuilder.append("<h4>" + "<h4>");
                    stringBuilder.append("</td>");
                }
            }
            stringBuilder.append("<tr>");
        }

        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }
}
