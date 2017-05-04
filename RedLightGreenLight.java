import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RedLightGreenLight extends Application {

    private static BorderPane pane = new BorderPane();
    private RadioButton red = new RadioButton();
    private RadioButton yellow = new RadioButton();
    private RadioButton green = new RadioButton();
    private Circle redLight = new Circle(263, 215,  30, Color.GRAY);
    private Circle yellowLight = new Circle(263, 280,  30, Color.GRAY);
    private Circle greenLight = new Circle(263, 280 + 65,  30, Color.GRAY);
    private final ToggleGroup group = new ToggleGroup();

    public static void main(String[] args){
        launch(args);
        System.out.println(pane.getWidth() );
    }

    public void start(Stage stage){

        FlowPane flow = new FlowPane();
        flow.setHgap(5);
        flow.setAlignment(Pos.CENTER);
        red.setToggleGroup(group);
        yellow.setToggleGroup(group);
        green.setToggleGroup(group);
        flow.getChildren().addAll(red, new Label("Red"), yellow, new Label("Yellow"), green, new Label("Green"));

        pane.setBottom(flow);
        pane.setPrefSize(500, 500);

        Rectangle light = new Rectangle(225, 175, 75, 210 );
        //Circle redLight = new Circle(263, 215,  30, Color.RED);
        pane.getChildren().addAll(light, redLight, yellowLight, greenLight);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        red.setOnAction(event -> {
            redLight.setFill(Color.RED);
            yellowLight.setFill(Color.GRAY);
            greenLight.setFill(Color.GRAY);
        });

        yellow.setOnAction(event -> {
            redLight.setFill(Color.GRAY);
            yellowLight.setFill(Color.YELLOW);
            greenLight.setFill(Color.GRAY);
        });

        green.setOnAction(event -> {
            redLight.setFill(Color.GRAY);
            yellowLight.setFill(Color.GRAY);
            greenLight.setFill(Color.LIGHTGREEN);
        });
    }


}
