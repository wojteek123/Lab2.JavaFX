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
    public Label error;
    public Label error2;
    public void initialize() {
        error.setVisible(false);
        error2.setVisible(false);
    }


    @FXML
    protected void onHelloButtonClick() {
        String ws_height = w_height.getText();
        String ws_radius = w_radius.getText();
        String ws_grubosc = w_grubosc.getText();

        if(checkTextField(ws_height) && checkTextField(ws_radius) && checkTextField(ws_grubosc) ) {
            error.setVisible(false);
            double wd_height = Double.parseDouble(ws_height);
            double wd_radius = Double.parseDouble(ws_radius);
            double wd_grubosc = Double.parseDouble(ws_grubosc);
            if(wd_height<=wd_grubosc || wd_radius<wd_grubosc){
                error2.setVisible(true);
                return;
            }
            error2.setVisible(false);


            double V1 = 3.14*(wd_radius*wd_radius)*wd_height;
            double V2 = 3.14*((wd_radius-wd_grubosc)*(wd_radius-wd_grubosc))*(wd_height-(2*wd_grubosc));

            System.out.printf("V1 = "+String.valueOf(V1)+"\n");
            System.out.printf("V2 = "+String.valueOf(V2)+"\n");

        }else {
            error.setVisible(true);

        }
        //String s = w_height.getText();
        //results.appendText(s);
        //count+=1;
        //String s=Integer.toString(count);
        //counter.setText(s);
        //button.setText("I jescze raz");

    }

    public boolean checkTextField(String data) {
            return data != null && data.matches("[0-9.]+");
        }
    public double volume(double height,double radius){
        return 1d;

    }
}