package com.example.user.javacoretraining.threeblock;

public class Zadanie2 {

    public static void main(String[] args) {

        Point koordinatu = neskolkoPerehodov();
        System.out.println("x=" + koordinatu.getX() + "; y=" + koordinatu.getY());



    }


    // принимает текущие извне координаты
    public static Point pointKoordinate(Point point, Directions napravlenie) {
        Point itog = new Point(point.getX(), point.getY());

        switch (napravlenie) {
            case UP:
                itog.setX(point.getX() + 0);
                itog.setY(point.getY() +1);
                break;
            case RIGHT:
                itog.setX(point.getX() + 1);
                itog.setY(point.getY() + 0);
                break;
            case DOWN:
                itog.setX(point.getX() + 0);
                itog.setY(point.getY() -1);
                break;
            case LEFT:
                itog.setX(point.getX() -1);
                itog.setY(point.getY() + 0);
                break;
        }

        return itog;
    }


    public static Point neskolkoPerehodov() {
        Point location = new Point(0, 0); // начальные координаты

        Directions up = Directions.UP;
        Directions right = Directions.RIGHT;
        Directions down = Directions.DOWN;
        Directions left = Directions.LEFT;

        // массив направлений
        Directions[] directions = {up, up, left, down, left, down, down, right, right, down, right};

        for (int i = 0; i < directions.length; i++) {
            location = pointKoordinate(location, directions[i]);
        }

        return location;
    }


}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


// направления движения
enum Directions {

    LEFT,
    UP,
    RIGHT,
    DOWN
}
