package com.example.labb3;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ShapeViewModel {
    public boolean undo;
    ObservableList<Position> positionList = FXCollections.observableArrayList();
    record Position (boolean isCircle, double mX, double mY, int x, int y, Color value){ }
    public GraphicsContext context;





    public void setNewBackground(Canvas canvas){
        canvas.getGraphicsContext2D();
        context = canvas.getGraphicsContext2D();
        context.setFill(Color.BEIGE);
        context.fillRect(0,0,800,600);
    }

    public void paintRect(double mouseX, double mouseY, int x, int y, Color value){
        context.setFill(Color.web(String.valueOf(value)));
        context.fillRect(mouseX, mouseY, x,y);
        if(!undo)
            positionList.add(new Position(false, mouseX, mouseY, x, y, value));
    }

    public void paintCircle(double mouseX, double mouseY, int x, int y, Color value){
        context.setFill(Color.web(String.valueOf(value)));
        context.fillOval(mouseX, mouseY,x, y);
        if(!undo)
            positionList.add(new Position(true, mouseX, mouseY, x, y, value));
    }
}
