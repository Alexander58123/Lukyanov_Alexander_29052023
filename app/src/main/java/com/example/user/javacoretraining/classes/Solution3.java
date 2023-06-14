package com.javarush.task.Prakticum.Zadacha3.Classes;

public class Solution3 {

    public static void main(String[] args) {

        Point point1 = new Point(5.0, 5.0);
        Point point2 = new Point(8.0, -3.0);
        Point point3 = new Point(-4.0, 1.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        // стороны треугольника
        System.out.println(triangle.getSide1());
        System.out.println(triangle.getSide2());
        System.out.println(triangle.getSide3());

        // периметр
        System.out.println("Периметр = " + triangle.Perimetr());

        // площадь
        System.out.println("Площадь = " + triangle.areaPloshad());

        // точка пересечения медиан
        double tochkaA = triangle.tochkaPerMedian().getX();
        double tochkaB = triangle.tochkaPerMedian().getY();
        System.out.println("Пересечение медиан: " + tochkaA + " " + tochkaB);
    }
}

class Triangle {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    private double side1;
    private double side2;
    private double side3;

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public Triangle(Point point1, Point point2, Point point3) {
        // это вершины
        this.x1 = point1.getX();
        this.y1 = point1.getY();
        this.x2 = point2.getX();
        this.y2 = point2.getY();
        this.x3 = point3.getX();
        this.y3 = point3.getY();
        // это стороны
        side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        side2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
    }

    // нахождение периметра
    public double Perimetr() {
        return side1 + side2 + side3;
    }

    // нахождение площади
    public double areaPloshad() {
        double poluPerimetr = (side1 + side2 + side3) / 2;
        return Math.sqrt(poluPerimetr * (poluPerimetr - side1) * (poluPerimetr - side2) * (poluPerimetr - side3));
    }

    // точка пересечения медиан
    public Point tochkaPerMedian() {
        Point itog = null;
        double x = (x1 + x2 + x3) / 3;
        double y = (y1 + y2 + y3) / 3;
        return itog = new Point(x, y);
    }

}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public  double getY() {
        return y;
    }
}

