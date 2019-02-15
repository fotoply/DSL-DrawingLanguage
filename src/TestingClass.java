import builder.FluentMachine;
import executor.Executor;

import java.awt.*;

public class TestingClass extends FluentMachine {

    public static void main(String[] args) {
        Object("House",
                Square().position(0, 10).size(50, 50),
                Line().position(25, 0).size(0, 10),
                Triangle().position(0, 0).xPoints(0, 25, 50).yPoints(10, 0, 10),
                Square().position(10, 30).size(15, 30));

        Executor.Show(
                Canvas(500, 500,
                        LoadObject("House"),
                        LoadObject("House").position(60, 60),
                        LoadObject("House").position(100, 100),
                        Square().position(10, 10).size(20, 20).color(Color.RED),
                        Line().position(5, 10).size(-5, 5).color(Color.GREEN),
                        Triangle().position(60, 10).xPoints(0, 10, 20).yPoints(10,0,10),
                        LoadObject("House").position(50, 50).size(2, 2)
                ));
    }

}
