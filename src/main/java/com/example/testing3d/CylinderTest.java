package com.example.testing3d;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class CylinderTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Cylinder coin = new Cylinder(50, 5);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.SILVER);
        coin.setMaterial(material);

        coin.setRotationAxis(Rotate.X_AXIS);
        coin.setRotate(90);

        Group coinGroup = new Group(coin);
        SubScene subScene = new SubScene(coinGroup,600,400, true, SceneAntialiasing.BALANCED);
        subScene.setCamera(new PerspectiveCamera());


        Button flipButton = new Button("Flip Coin");
        flipButton.setOnAction(e -> {
            RotateTransition rt = new RotateTransition(Duration.seconds(60), coin);
            rt.setAxis(Rotate.Y_AXIS);
            rt.setByAngle(720);
            rt.setCycleCount(1);
            rt.setInterpolator(Interpolator.EASE_BOTH);
            rt.play();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(subScene, flipButton);

        Scene scene = new Scene(layout, 800, 600);


        primaryStage.setTitle("Coin Filp");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

