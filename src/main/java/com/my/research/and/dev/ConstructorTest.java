package com.my.research.and.dev;

public class ConstructorTest {

    public static void main(String[] args) {
        new TestChild();
    }
}

class TestMain {
    public TestMain() {
        System.out.println("Test Main");
    }
}

class TestChild extends TestMain {
    public TestChild() {
        System.out.println("Test Child");
    }
}
