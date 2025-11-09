package com.yugesh.cloneingObjects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Human implements Cloneable{

    String name;
    int age;


    public Human(Human other){
        this.age=other.age;
        this.name=other.name;
    }

    //by default it is shallow copy not deep
    @Override
    public Human clone() {
        try {
            Human clone = (Human) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
