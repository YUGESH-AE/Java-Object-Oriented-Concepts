package com.yugesh.fileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteStream {
    static void main() {

        String filePath = "C://Users//aeyug//IdeaProjects//Java-Object-Oriented-Concepts//src//main//resources//file.txt";
        String message = "How are you";
        try (
                FileOutputStream out = new FileOutputStream(filePath);
                FileInputStream in = new FileInputStream(filePath);
        ) {

            out.write(message.getBytes());
            int i;
            while ((i = in.read()) != -1) {
                System.out.println((char) i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
