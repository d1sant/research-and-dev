package com.my.research.and.dev.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExtendAndSuper {

    // In processing the square,
    // I'll take for input  any type of List that can PRODUCE (read) squares.
    // I'll take for output any type of List that can ACCEPT (write) squares.
    static void processSquare(List<? extends Square> iSqua, List<? super Square> oSqua) {
        Square s = iSqua.remove(0);
        s.doSquare();
        oSqua.add(s);
    }

    static void processCircle(List<? extends Circle> iCirc, List<? super Circle> oCirc) {
        Circle c = iCirc.remove(0);
        c.doCircle();
        oCirc.add(c);
    }

    public static void main(String[] args) {
        // Load some inputs
        List<Circle> circles = makeList(new Circle());
        List<DoubleSquare> dsqares = makeList(new DoubleSquare());
        dsqares.add(new SuperDoubleSquare());

        // Collated storage for completed shapes
        List<Shape> processed = new ArrayList<Shape>();

        // Process the shapes
        processSquare(dsqares, processed);
        processCircle(circles, processed);

        // Do post-processing
        for (Shape s : processed)
            s.shapeDone();
    }

    static class Shape { void shapeDone() { System.out.println("Done with shape."); } }
    static class Square extends Shape { void doSquare() { System.out.println("Square!"); } }
    static class DoubleSquare extends Square {}
    static class SuperDoubleSquare extends DoubleSquare {}
    static class Circle extends Shape { void doCircle() { System.out.println("Circle!"); } }

    static <T> List<T> makeList(T a) {
        List<T> list = new LinkedList<T>();
        list.add(a);
        return list;
    }
}
