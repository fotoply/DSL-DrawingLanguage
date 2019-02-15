package model;

import java.awt.*;

public interface DrawableElement extends Cloneable {
    /**
     * Sets the elements position on the canvas.
     * <br></br>
     * Coordinate system starts in the upper left corner
     * @param x x coordinate
     * @param y y coordinate
     * @return the element itself
     */
    DrawableElement position(int x, int y);

    /**
     * Sets the size of an element
     * @param width the desired width
     * @param height the desired height
     * @return the element itself
     */
    DrawableElement size(int width, int height);

    /**
     * Sets the color of an element
     * @param color A Java AWT color
     * @return the element itself
     */
    DrawableElement color(Color color);

    /**
     * Called by the executor when executing the model. Each draw method has full access to the canvas, in principle.
     * @param context the graphics context
     */
    void draw(Graphics context);

    int getX();

    int getY();

    int getHeight();

    int getWidth();
}
