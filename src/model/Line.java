package model;

import java.awt.*;

public class Line implements DrawableElement {

    private int x, y = 0;
    private int width, height = 0;
    private String name;
    private Color color = Color.BLACK;

    public Line(String name) {
        this.name = name;
    }

    @Override
    public Line position(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public Line size(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    @Override
    public Line color(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public void draw(Graphics context) {
        context.setColor(color);
        context.drawLine(x, y, x+width, y+height);
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
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }
}
