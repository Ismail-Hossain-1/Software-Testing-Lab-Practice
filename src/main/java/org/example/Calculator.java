package org.example;

public class Calculator {

    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }

    public double divide(int a, int b){
        double ans;
        try{
            ans= a/b;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("b must not be 0");
        }
        return ans;
    }

}
