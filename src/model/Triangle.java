package model;

import java.awt.*;

public class Triangle implements DrawableElement {

    private int x, y = 0;
    private int width, height = 0;
    private String name;
    private Color color = Color.BLACK;
    private int[] xPoints = new int[3];
    private int[] yPoints = new int[3];

    public Triangle(String name) {
        this.name = name;
    }

    @Override
    public Triangle position(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public Triangle size(int width, int height) {
        //this.width = width;
        //this.height = height;
        return this;
    }

    @Override
    public Triangle color(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public void draw(Graphics context) {
        context.setColor(color);
        context.drawPolyline(new int[]{xPoints[0]+x, xPoints[1]+x, xPoints[2]+x}, new int[]{yPoints[0]+x, yPoints[1]+x, yPoints[2]+x}, 3);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public Triangle xPoints(int x1, int x2, int x3) {
        xPoints = new int[]{x1, x2, x3};
        return this;
    }

    public Triangle yPoints(int y1, int y2, int y3) {
        yPoints = new int[]{y1, y2, y3};
        return this;
    }

    @Override
    protected Triangle clone() throws CloneNotSupportedException {
        return (Triangle) super.clone();
    }
}
