package executor;

import model.Canvas;
import model.DrawableElement;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Executor {
    public static void Show(Canvas canvas) {
        Show(Draw(canvas));
    }

    public static void Show(BufferedImage image) {
        JFrame jFrame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        jFrame.add(label);
        jFrame.setDefaultCloseOperation(3);
        jFrame.pack();
        jFrame.show();
    }

    public static BufferedImage Draw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        BufferedImage drawableSpace = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = drawableSpace.createGraphics();
        for (DrawableElement element : canvas.getElements()) {
            element.draw(graphics);
        }
        return drawableSpace;
    }
}