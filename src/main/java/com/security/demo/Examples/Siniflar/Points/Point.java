package com.security.demo.Examples.Siniflar.Points;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToOrigin(){
        return (Math.sqrt(x*x + y*y));
    }

    public double distanceToPoint(Point p){
        return Math.sqrt(Math.pow((p.getX()-x),2) + Math.pow((p.getY()-y),2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
