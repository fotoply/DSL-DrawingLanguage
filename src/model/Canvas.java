package model;

import java.util.*;

public class Canvas {

    private List<DrawableElement> drawableList;
    private int width;
    private int height;

    public Canvas(int width, int height, DrawableElement[] elements) {
        this.width = width;
        this.height = height;
        this.drawableList = Arrays.asList(elements);
    }

    public List<DrawableElement> getElements() {
        return drawableList;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
