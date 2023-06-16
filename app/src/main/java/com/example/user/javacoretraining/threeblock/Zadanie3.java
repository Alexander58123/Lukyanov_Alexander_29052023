package com.example.user.javacoretraining.threeblock;

public class Zadanie3 {

    public static void main(String[] args) {

        // прямоугольник
        Rectangle rectangle = new Rectangle(5, 9);
        System.out.println("Периметр " + rectangle.perimeter());
        System.out.println("Площадь " + rectangle.area());

        // квадрат
        Square square = new Square(7);
        System.out.println("\nПериметр " + square.perimeter());
        System.out.println("Площадь " + square.area());

        // круг
        Circle circle = new Circle(9);
        System.out.println("\nПериметр " + circle.perimeter());
        System.out.println("Площадь " + circle.area());


    }
}

interface Shape {

    double perimeter(); // периметр

    double area(); // площадь
}

// прямоугольник
class Rectangle implements Shape {
    private double shirina;
    private double dlina;

    public Rectangle(double shirina, double dlina) {
        this.shirina = shirina;
        this.dlina = dlina;
    }

    @Override
    public double perimeter() {
        return (shirina + dlina) * 2;
    }

    @Override
    public double area() {
        return shirina * dlina;
    }

}

// квадрат
class Square implements Shape {
    private double dlinaStoronu;

    public Square(double dlinaStoronu) {
        this.dlinaStoronu = dlinaStoronu;
    }

    @Override
    public double perimeter() {
        return dlinaStoronu * 4;
    }

    @Override
    public double area() {
        return dlinaStoronu * dlinaStoronu;
    }
}


// круг
class Circle implements Shape {
    private static final double pi = 3.1415;
    private double diametr;


    public Circle(double diametr) {
        this.diametr = diametr;
    }

    @Override
    public double perimeter() {
        return 2 * pi * (diametr / 2);
    }

    @Override
    public double area() {
        return pi * (diametr / 2) * (diametr / 2);
    }
}
