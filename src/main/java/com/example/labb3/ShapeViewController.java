package com.example.labb3;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.stage.Stage;

public class ShapeViewController {

    public Button undoButton;
    public boolean isCircle;
    public ColorPicker colorPicker;
    public Button circleButton;
    public TextField sizeField;
    ShapeViewModel shapeViewModel = new ShapeViewModel();
    public Stage stage;
    public Canvas canvas;

    FileChooser fileChooser = new FileChooser();
    SvgFileWriter svgFileWriter = new SvgFileWriter();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(){
        fileChooser.setInitialDirectory(new File("C:\\temp"));
        shapeViewModel.setNewBackground(canvas);
        circleButton.isPressed();
        isCircle = true;
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        if(isCircle) {
            shapeViewModel.paintCircle(mouseEvent.getX(), mouseEvent.getY(), Integer.parseInt(sizeField.getText()), Integer.parseInt(sizeField.getText()), colorPicker.getValue());
            System.out.println(colorPicker.getValue());
        }
        else {
            shapeViewModel.paintRect(mouseEvent.getX(), mouseEvent.getY(), Integer.parseInt(sizeField.getText()), Integer.parseInt(sizeField.getText()), colorPicker.getValue());
        }
        if(shapeViewModel.positionList.size() > 1)
            undoButton.setDisable(false);
    }

    public void resetButton(ActionEvent actionEvent) {
        shapeViewModel.setNewBackground(canvas);
        undoButton.setDisable(true);
        shapeViewModel.undo = false;
        shapeViewModel.positionList.clear();
    }

    public void circleButton(ActionEvent actionEvent) {
        isCircle = true;
    }

    public void rectangleButton(ActionEvent actionEvent) {
        isCircle = false;
    }

    public void undoButton(ActionEvent actionEvent) {
        shapeViewModel.undo = true;
        shapeViewModel.setNewBackground(canvas);
        for (int i = 0; i < shapeViewModel.positionList.size()-1; i++) {
            if(shapeViewModel.positionList.get(i).isCircle())
                shapeViewModel.paintCircle(shapeViewModel.positionList.get(i).mX(), shapeViewModel.positionList.get(i).mY(), shapeViewModel.positionList.get(i).x(),shapeViewModel.positionList.get(i).y(),shapeViewModel.positionList.get(i).value());
            else
                shapeViewModel.paintRect(shapeViewModel.positionList.get(i).mX(), shapeViewModel.positionList.get(i).mY(), shapeViewModel.positionList.get(i).x(),shapeViewModel.positionList.get(i).y(),shapeViewModel.positionList.get(i).value());
        }
        int a = shapeViewModel.positionList.size() -1;
        shapeViewModel.positionList.remove(a);
        shapeViewModel.undo = false;
        if(shapeViewModel.positionList.size() == 0)
            undoButton.setDisable(true);
    }

    public void exportSVGFile(ActionEvent actionEvent) {
        svgFileWriter.saveToFile(shapeViewModel, stage);
    }
}
