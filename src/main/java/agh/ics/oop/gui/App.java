package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.geometry.HPos;

import javax.swing.*;
import java.util.*;

public class App extends Application{
    private AbstractWorldMap map;
    private SimulationEngine engine;

    @Override
    public void init() throws Exception {
        List<String> args = getParameters().getRaw();
        MoveDirection[] directions = new OptionsParser().parse(args);
        List<Vector2d> positions = Arrays.asList(new Vector2d(2,2), new Vector2d(3,4));
        this.map = new GrassField(10);
        this.engine = new SimulationEngine(directions, map, positions);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Label label1 = new Label("Zwierzak");

        GridPane grid  = new GridPane();
        grid.setGridLinesVisible(true);


        int label_x = this.map.getLowerLeft().x;
        int label_y = this.map.getUpperRight().y;

        for(int i = 0; i <= this.map.getUpperRight().x - this.map.getLowerLeft().x + 1; i++){
            for(int j = 0; j <= this.map.getUpperRight().y - this.map.getLowerLeft().y + 1; j++){
                if(i == 0 && j == 0){
                    Label label = new Label("y/x");
                    grid.add(label, i, j);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                else if(j == 0){ // os X
                    Label label = new Label(Integer.toString(label_x));
                    grid.add(label, i, j);
                    GridPane.setHalignment(label, HPos.CENTER);
                    label_x += 1;
                }
                else if(i == 0){ // os y
                    Label label = new Label(Integer.toString(label_y));
                    grid.add(label, i, j);
                    GridPane.setHalignment(label, HPos.CENTER);
                    label_y -= 1;
                }
                else{
                    if(this.map.getAnimals().containsKey(new Vector2d(i, j))){
                        Label label = new Label("*");
                        grid.add(label, i, j);
                        GridPane.setHalignment(label, HPos.CENTER);
                    }

                    if(this.map.getGrasses().containsKey(new Vector2d(i, j))){
                        Label label = new Label("*");
                        grid.add(label, i, j);
                        GridPane.setHalignment(label, HPos.CENTER);
                    }
                }
            }
        }

        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(30));

        for(int i = 0; i < this.map.getUpperRight().x - this.map.getLowerLeft().x + 1; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(40));
        }

        for(int j = 0; j < this.map.getUpperRight().y - this.map.getLowerLeft().y + 1; j++){
            grid.getRowConstraints().add(new RowConstraints(40));
        }

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
