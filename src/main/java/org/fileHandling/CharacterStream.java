package org.fileHandling;

import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStream {

    public static void main(String[] args) {
        String filePath = "C://Users//aeyug//IdeaProjects//Java-Object-Oriented-Concepts//src//main//resources//file.txt";
        String message = "How are you";
        try (
                FileWriter writer = new FileWriter(filePath);
                FileReader reader = new FileReader(filePath);
        ) {

            writer.write(message);
            int i;
            while ((i = reader.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
