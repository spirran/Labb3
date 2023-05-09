package com.example.labb3;

import javafx.scene.control.ColorPicker;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShapeViewModelTest {
    java.awt.Color awtColor;
    int r = 50;
    int g = 50;
    int b = 50;
    int a = 255;
    double opacity = a / 255.0 ;
    javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);

    ShapeViewModel model = new ShapeViewModel();

    @Test
    void createACircleAndAddItToList(){
        model.paintCircle(10, 10, 10, 10, fxColor);

        var expected = 1;
        var actual = model.positionList.size();

        assertEquals(expected, actual);
    }

}