package model;

import java.awt.*;

public class Square implements DrawableElement {

    private int x, y = 0;
    private int width, height = 0;
    private String name;
    private Color color = Color.BLACK;

    public Square(String name) {
        this.name = name;
    }

    @Override
    public Square position(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public Square color(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public void draw(Graphics graphicsContext) {
        graphicsContext.setColor(color);
        graphicsContext.drawRect(x, y, width, height);
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

    @Override
    public Square size(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    @Override
    protected Square clone() throws CloneNotSupportedException {
        return (Square) super.clone();
    }
}
