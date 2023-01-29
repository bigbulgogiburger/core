package hello.core;

import lombok.*;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(3);
        System.out.println("helloLombok = " + helloLombok);

    }
}
