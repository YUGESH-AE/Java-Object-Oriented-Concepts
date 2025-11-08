package com.yugesh.inheritance;

public class Box {

    double length;
    double height;
    double width;

    public Box(double length, double height, double width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    Box() {
        this.length = -1;
        this.width = -1;
        this.height = -1;
    }

    Box(double side) {
        this.width = side;
        this.height = side;
        this.length = side;

    }

    Box(Box old) {
        this.width = old.width;
        this.height = old.height;
        this.length = old.length;
    }

    public void information() {
        System.out.println("Running the box");
    }
}
