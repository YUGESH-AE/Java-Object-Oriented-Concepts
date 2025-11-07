package org.Strings_StringBuilder;

public class Main {
    
    public static void main(String[] args) {
        String str="yugesh";
    String str2="yugesh";

    System.out.println(str==str2); // truel̥


    String s1=new String("chan");
    String s2=new String("chan");
    System.out.println(s1==s2); // false
    System.out.println(s1.equals(s2)); // true
    }
    
}
