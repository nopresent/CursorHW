package com.cursorhw.hw4;

abstract class SpaceShape extends Shape implements Interface.AreaMeasurable, Interface.VolumeMeasurable {

}

class SquarePyramid extends SpaceShape {

    public SquarePyramid(double x1, double y1, double z1, double width, double height) {
        setX1(x1);
        setY1(y1);
        setZ1(z1);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public double getArea() {
        // https://goo.su/7zQL
        /*
          Ищем диаглональ основания пирамиды -> квадрата
         */
        double diagonal = Math.pow(2, 2) * getWidth();

        /*
           Ищем длинну боковой грани - Гипотенуза равнобедренного треугольника
           Катет 1 - половина diagonal
           Катет 2 - height
         */
        double hypotenuse = Math.sqrt(Math.pow(diagonal / 2, 2) + Math.pow(getHeight(), 2));
        return Math.pow(getWidth(), 2) + 2 * getWidth() * Math.sqrt(Math.pow(hypotenuse, 2) - (Math.pow(getWidth(), 2) / 4));
    }

    @Override
    public double getVolume() {
        // https://goo.su/7zQO
        return (getHeight() * Math.pow(getWidth(), 2)) / 3;
    }

    @Override
    public String toString() {
        return getClass() + " {" +
                "x1:" + getX1() +
                ", y1:" + getY1() +
                ", z1:" + getZ1() +
                ", width:" + getWidth() +
                ", height:" + getHeight() +
                ", Volume:" + getVolume() +
                ", Area:" + getArea() +
                "}";
    }
}

class Cuboid extends SpaceShape {

    // https://goo.su/7ZQQ
    public Cuboid(double x1, double y1, double z1, double width, double height, double depth) {
        setX1(x1);
        setY1(y1);
        setZ1(z1);
        setWidth(width);
        setHeight(height);
        setDepth(depth);
    }

    @Override
    public double getArea() {
        return 2 * (getWidth() * getHeight() + getHeight() * getDepth() + getWidth() * getDepth());
    }

    @Override
    public double getVolume() {
        return getWidth() * getHeight() * getDepth();
    }

    @Override
    public String toString() {
        return getClass() + " {" +
                "x1:" + getX1() +
                ", y1:" + getY1() +
                ", z1:" + getZ1() +
                ", width:" + getWidth() +
                ", height:" + getHeight() +
                ", depth:" + getDepth() +
                ", Volume:" + getVolume() +
                ", Area:" + getArea() +
                "}";
    }

}

class Sphere extends SpaceShape {

    public Sphere(double x1, double y1, double z1, double radius) {
        setX1(x1);
        setY1(y1);
        setZ1(z1);
        setRadius(radius);
    }

    @Override
    public double getArea() {
        return Math.PI * 4 * Math.pow(getRadius(), 2);
    }

    @Override
    public double getVolume() {
        return (4 * Math.PI * Math.pow(getRadius(), 3)) / 3;
    }

    @Override
    public String toString() {
        return getClass() + " {" +
                "x1:" + getX1() +
                ", y1:" + getY1() +
                ", z1:" + getZ1() +
                ", radius:" + getRadius() +
                ", Volume:" + getVolume() +
                ", Area:" + getArea() +
                "}";
    }
}