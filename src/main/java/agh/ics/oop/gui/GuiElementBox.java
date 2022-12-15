package agh.ics.oop.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class GuiElementBox {
    private final VBox box;
    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src/main/resources/" + element.getResourceName() + ".png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        Label label = new Label(element.getName());
        label.setTextAlignment(TextAlignment.CENTER);

        this.box = new VBox(imageView, label);
        box.setAlignment(Pos.CENTER);
    }

    public VBox getVBox(){
        return this.box;
    }
}
