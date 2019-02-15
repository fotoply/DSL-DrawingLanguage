package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomElement implements DrawableElement {

    private List<DrawableElement> elementList;
    private int x, y = 0;
    private int width = 1;
    private int height = 1;
    private int maxWidth, maxHeight;
    private Color color = Color.BLACK;

    public CustomElement(DrawableElement[] elements) {
        this.elementList = new ArrayList<>();
        Collections.addAll(elementList, elements);
        for (DrawableElement element : elements) {
            if(element.getX() + element.getWidth() + 1 > maxWidth) {
                maxWidth = element.getX() + element.getWidth() + 1;
            }

            if(element.getY() + element.getHeight() + 1 > maxHeight) {
                maxHeight = element.getY() + element.getHeight() + 1;
            }
        }
    }

    @Override
    public CustomElement position(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public CustomElement size(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    @Override
    public CustomElement color(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public void draw(Graphics context) {
        BufferedImage temporaryImage = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);
        temporaryImage.getGraphics().setColor(color);
        for (DrawableElement element : elementList) {
            element.draw(temporaryImage.getGraphics());
        }

        Image img = temporaryImage.getScaledInstance(width*maxWidth, height*maxHeight, Image.SCALE_DEFAULT);
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        temporaryImage = bimage;

        context.drawImage(temporaryImage, x, y, null);

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
        return width * maxWidth;
    }

    @Override
    public int getHeight() {
        return height * maxHeight;
    }

    @Override
    public CustomElement clone() throws CloneNotSupportedException {
        return (CustomElement) super.clone();
    }
}
