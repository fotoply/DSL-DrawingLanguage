package model;

import java.awt.*;

public interface DrawableElement extends Cloneable {
    DrawableElement position(int x, int y);

    DrawableElement size(int width, int height);

    DrawableElement color(Color color);

    void draw(Graphics context);

    int getX();

    int getY();

    int getHeight();

    int getWidth();
}
