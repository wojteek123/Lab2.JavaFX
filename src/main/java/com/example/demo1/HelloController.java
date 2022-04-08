package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label counter;
    public Button button;
    public int count=0;
    @FXML
    protected void onHelloButtonClick() {
        count+=1;
        String s=Integer.toString(count);
        counter.setText(s);
        button.setText("I jescze raz");
    }

}