package org.staticExample;


public class Human {

     int age;
     String name;
     int salary;
     boolean married;

    static long population;



    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population+=1;
    }


    public static void main(String[] args) {
        Human yugesh=new Human(26,"yugesh",70000,false);
        Human ram=new Human(26,"Ram",70000,false);
        System.out.println(yugesh.population);

    }
}
