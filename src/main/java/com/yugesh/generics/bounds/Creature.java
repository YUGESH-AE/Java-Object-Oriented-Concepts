package com.yugesh.generics.bounds;

public class Creature {
    
}

class Animal extends Creature{

    public void sound(){
        System.out.println("Animal is shouting");
    }

}

class Dog extends Animal{

}

class Cat extends Animal{

}

class Husky extends Dog{

}

class InidanCat extends Cat{

}
