package org.sergei;

/**
 * Created by Sergei on 13.01.2016.
 */
public class Outer {
    private int number;

    public Outer(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    class Inner {
        public void get(){
            System.out.println(number);

        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer(10);
        Inner inner = outer.new Inner();
        inner.get();
        outer.setNumber(20);
        inner.get();
    }
}
