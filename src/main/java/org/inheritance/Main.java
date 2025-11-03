package org.inheritance;

public class Main {

    public static void main(String[] args) {
        Box box=new Box(20);
        System.out.println("Box length:"+box.length+" box height:"+box.height+" box width:"+box.width);
        BoxWeight boxWeight=new BoxWeight(20);
        System.out.println("Box length:"+boxWeight.length+" boxWeight height:"+boxWeight.height+" box width:"+box.width
        +" box weight:"+boxWeight.weight);
    }
    
}
