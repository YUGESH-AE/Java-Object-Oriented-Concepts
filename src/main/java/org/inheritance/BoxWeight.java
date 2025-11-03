package org.inheritance;

public class BoxWeight extends Box {

    double weight;

    public BoxWeight(){
        super();
        this.weight=-1;
    }
    public BoxWeight(double length, double height, double width, double weight) {
        super(length, height, width);
        this.weight = weight;
    }
    public BoxWeight(double sides){
        super(sides);
        this.weight=sides;
    }
    
    
}
