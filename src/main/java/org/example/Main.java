package org.example;

public class Main {
    public static void main(String[] args) {
        // This method is static, thus it does not need object instantiation
        Test.method2();
        // This method is non-static, it does need to create an object first.
        Test test = new Test();
        test.method1();

        // Method reference: reference::methodName

        // 1. Static method reference
        // Test::method2();

        // 2. Instance method reference
        // test::method1();

        // 3. Constructor reference

    }
}

class Test {
    public void method1() {
        System.out.println("Method 1: Instance/Non-static method");
    }

    public static void method2() {
        System.out.println("Method 2: Static method");
    }
}