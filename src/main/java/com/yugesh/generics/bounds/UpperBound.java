package com.yugesh.generics.bounds;

public class UpperBound {

    static void main() {

        Home<Dog> dog = new Home<>(new Dog(), new Dog());
        System.out.println(dog.getAnimal1());
        Home<Cat> cat = new Home<>(new Cat(), new Cat());
        System.out.println(cat.getAnimal1());

        // Home<Creature>creature=new Home<>(new Creature(), new Creature());
    }
}


class Home<T extends Animal> {

    private T animal1;
    private T animal2;

    public Home(T animal1, T animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    public T getAnimal1() {
        animal1.sound();
        return animal1;
    }

    public T getAnimal2() {
        return animal2;
    }


}