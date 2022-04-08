package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    /*
    private Label counter;
    public Button button;
    public int count=0;
    */
    public TextField w_height;
    public TextField w_radius;
    public TextField w_grubosc;
    public TextArea results;



    @FXML
    protected void onHelloButtonClick() {
        String s= w_height.getText();
        results.appendText(s);
        //count+=1;
        //String s=Integer.toString(count);
        //counter.setText(s);
        //button.setText("I jescze raz");

    }

}