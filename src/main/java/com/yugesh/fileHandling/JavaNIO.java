package com.yugesh.fileHandling;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JavaNIO {

    public static void main(String[] args) {
        try {
            ClassLoader classLoader = JavaNIO.class.getClassLoader();

            Path path = Paths.get(classLoader.getResource("file.txt").toURI());

            Files.writeString(path, "How are you");
            System.out.println(Files.readString(path));

            List<String> out = Files.readAllLines(path);
            for (String i : out) {
                System.out.println(i);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
