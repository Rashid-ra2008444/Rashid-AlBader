package org.example.q6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Interface extends Application {
    Stage primaryStage;
    Scene scene;
    GridPane root;
    Label l1,l2,l3,l4;
    TextField tf1,tf2;
    RadioButton rb1,rb2;
    ToggleGroup tg;
    Button b1,b2;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            root = new GridPane();
            l1 = new Label("Welcome to the Hospital Management System");
            l2 = new Label("User Name");
            l3 = new Label("Password");
            l4 = new Label("User Type");
            tf1 = new TextField();
            tf2 = new TextField();
            tg = new ToggleGroup();
            rb1 = new RadioButton("System User"); tg.selectToggle(rb1);
            rb2 = new RadioButton("Admin");tg.selectToggle(rb2);
            b1 = new Button("Log in");
            b2 = new Button("Clear");

            b1.setOnAction((e)->{
                String username = tf1.getText();
                String password =  tf2.getText();
                boolean isSystemUser = rb1.isPressed();
                boolean find = false;
                if(isSystemUser){

                }
            });

            root.add(l1,0,0,0,0);
            root.add(l2,0,1);
            root.add(tf1,1,1,2,1);
            root.add(l3,0,2);
            root.add(tf2,1,2,2,1);
            root.add(l4,0,3);
            root.add(rb1,1,3);
            root.add(rb2,2,3);
            root.add(b1,1,4);
            root.add(b2,2,4);
            root.setAlignment(Pos.CENTER);

            scene = new Scene(root,400,300);
            primaryStage.setTitle("Hospital Management System");
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
