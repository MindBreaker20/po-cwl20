package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.geometry.HPos;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;

public class App extends Application implements IAnimalPositionChangeObserver{
    private AbstractWorldMap map;
    private SimulationEngine engine;
    private GridPane grid;

    @Override
    public void init() throws Exception {
        List<String> args = getParameters().getRaw();
        List<Vector2d> positions = Arrays.asList(new Vector2d(2,2), new Vector2d(3,4));
        this.map = new GrassField(10);
        this.engine = new SimulationEngine(null, map, positions);
        this.engine.addObserver(this);
        this.engine.setMoveDelay(300);
        this.grid = new GridPane();
        gridRender(true);
    }

    public void gridRender(boolean first){
        grid.setGridLinesVisible(false);
        grid.setGridLinesVisible(true);

        Vector2d lowerLeft = this.map.getLowerLeft();
        Vector2d upperRight = this.map.getUpperRight();

        int columnIndex = 0;
        int rowIndex = upperRight.y - lowerLeft.y + 1;

        for(int i = lowerLeft.y; i <= upperRight.y; i++) { // wiersze
            grid.add(new Label("" + i), columnIndex, rowIndex);
            columnIndex++;
            for (int j = lowerLeft.x; j <= upperRight.x; j++) { // kolumny
                Vector2d pos = new Vector2d(j, i);
                if (map.isOccupied(pos)) {
                    try {
                        grid.add(new GuiElementBox(map.objectAt(pos)).getVBox(), columnIndex, rowIndex);
                    } catch (FileNotFoundException e) {
                        System.out.println("Nie znalezeiono tekstury dla tej pozycji");
                    }
                }
                columnIndex++;
            }
            rowIndex--;
            columnIndex = 0;
        }

        grid.add(new Label("y/x"), columnIndex, rowIndex);
        columnIndex++;

        for (int i = lowerLeft.x; i <= upperRight.x; i++) {
            grid.add(new Label("" + i), columnIndex, rowIndex);
            columnIndex++;
        }

        if(first){
            grid.getColumnConstraints().add(new ColumnConstraints(30));
            grid.getRowConstraints().add(new RowConstraints(30));
            for(int i = lowerLeft.x; i <= upperRight.x; i++){
                grid.getColumnConstraints().add(new ColumnConstraints(40));
            }
            for(int j = lowerLeft.y; j <= upperRight.y; j++){
                grid.getRowConstraints().add(new RowConstraints(40));
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField moves = new TextField();
        Button startButton = new Button("Start");
        startButton.setOnAction(action -> {
            List<MoveDirection> moveDirections = List.of(OptionsParser.parse(Arrays.asList(moves.getText().split(""))));
            engine.setMoveDirections(moveDirections);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

        VBox vbox = new VBox(moves, startButton);
        vbox.setPadding(new Insets(20));
        HBox hbox = new HBox(grid, vbox);
        hbox.setPadding(new Insets(20));

        Scene scene = new Scene(hbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception{
    }

    @Override
    public void animalPositionChange(){
        Platform.runLater(() -> {
            grid.getChildren().clear();
            gridRender(false);
        });
    }
}
