package com.cursorhw.hw4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Object> shapeList = new ArrayList<>();
        shapeList.add(new Rectangle(2, 2, 3, 4));
        shapeList.add(new Triangle(2, 2, 3, 6, 9, 9));
        shapeList.add(new Circle(2, 2, 4));
        shapeList.add(new SquarePyramid(5, 5, 5, 4, 5));
        shapeList.add(new Cuboid(5, 5, 5, 4, 5, 5));
        shapeList.add(new Sphere(5, 5, 6, 7));

        for (Object o : shapeList) {
            System.out.println(o.toString());
        }

    }


}
