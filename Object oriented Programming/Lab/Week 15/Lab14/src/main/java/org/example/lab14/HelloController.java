package org.example.lab14;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class HelloController {

    @FXML
    private Button ClrBTN;

    @FXML
    private Button DivBTN;

    @FXML
    private Button MulBTN;

    @FXML
    private Button PlusBTN;

    @FXML
    private TextField Result;

    @FXML
    private Button SubBTN;

    @FXML
    private TextField TextF_1;

    @FXML
    private TextField TextF_2;

    @FXML
    public void plusClicked(ActionEvent event) {
        calc("+");
    }
    @FXML
    public void subClicked(ActionEvent event) {
        calc("-");
    }
    @FXML
    public void divClicked(ActionEvent event) {
        calc("/");
    }
    @FXML
    public void mulClicked(ActionEvent event) {
        calc("*");
    }
    @FXML
    public void clrClicked(ActionEvent event) {
        TextF_1.setText("");
        TextF_2.setText("");
        Result.setText("");
    }


    private void calc(String op){
        double n1 = Double.parseDouble(TextF_1.getText());
        double n2 = Double.parseDouble(TextF_2.getText());
        double result = 0;
        switch (op) {
            case "+" -> result = n1 + n2;
            case "-" -> result = n1 - n2;
            case "*" -> result = n1 * n2;
            case "/" -> result = n1 / n2;
        }
        Result.setText(String.valueOf(result));
    }
}
