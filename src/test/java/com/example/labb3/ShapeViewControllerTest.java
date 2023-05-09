package com.example.labb3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeViewControllerTest {
    boolean isCircle = true;
    ShapeViewController shapeViewController = new ShapeViewController();



    @Test
    void isItACircleTest() {
        shapeViewController.isCircle = true;

        boolean actualCircle = shapeViewController.isCircle;
        boolean expectedCircle = true;

        assertEquals(actualCircle, expectedCircle);
    }

    @Test
    void onCanvasClickedTest() {

        int a = shapeViewController.shapeViewModel.positionList.size();

        var expected = 0;
        var actual = a;

        assertEquals(expected, actual);
    }
}