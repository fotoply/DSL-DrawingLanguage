package builder;

import model.*;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FluentMachine {


    private static Map<String, CustomElement> customElements = new HashMap<>();

    public static Canvas Canvas(int width, int height, DrawableElement... drawableElements) {
        return new Canvas(width, height, drawableElements);
    }

    public static Square Square() {
        return new Square("square_" + generateUUID());
    }

    public static Line Line() {
        return new Line("line_" + generateUUID());
    }

    public static Triangle Triangle() {
        return new Triangle("triangle_" + generateUUID());
    }

    public static void Object(String name, DrawableElement... elements) {
        CustomElement customElement = new CustomElement(elements);
        customElements.put(name, customElement);
    }

    public static DrawableElement LoadObject(String name) {
        try {
            return customElements.get(name).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Based on https://www.baeldung.com/java-random-string
    private static String generateUUID() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

}
