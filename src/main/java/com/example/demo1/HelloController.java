package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.RoundingMode;
import java.text.NumberFormat;

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
    public CheckBox corrosion;
    public void initialize() {
        error.setVisible(false);
        error2.setVisible(false);
    }
    public double shnumber(String numberString){
        int indexOfDecimal = numberString.indexOf('.');
        double truncatedNumber = Double.parseDouble(numberString.substring(0, indexOfDecimal + 3));
        return truncatedNumber;
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
            String temp="";
            results.setText(temp);

            double V1 = 3.14*(wd_radius*wd_radius)*wd_height;
            double V2 = 3.14*((wd_radius-wd_grubosc)*(wd_radius-wd_grubosc))*(wd_height-(2*wd_grubosc));
           ///System.out.printf("V1 = "+String.valueOf(V1)+"\n");
           // System.out.printf("V2 = "+String.valueOf(V2)+"\n");

            double steel_amount=V1-V2; //ilosc potrzebnej stali w cm szesciennych

            double weight = steel_amount*7.9; //stal wazy 7.9 gram na cm szescienny
            weight /= 1000; // na kg

            // Ile waży stal nierdzewna?
            //1 m2 blachy kwasoodpornej o grubości 1 mm waży około 8 kg.
            //1 m2 = 10 000 cm2 , 10 000cm2 * 0,1 cm = 1000cm3
            // 1000cm3 = 8kg ,      1cm3 = 0,008 kg
            double weight_corrosion=steel_amount*0.008;

            double price_steel=10d;
            double price_corrosion=16d; //za kg

            //System.out.printf("weight = "+String.valueOf(weight)+"kg \n");
            //System.out.printf("weight corrosion = "+String.valueOf(weight_corrosion)+"kg \n");

            double pole_b = 2*3.14*wd_radius*wd_height;
            double pole_p = 2*3.14*wd_radius*wd_radius;
            double pole_c = pole_b * pole_p*2;




            String textresult= "Ilość potrzebnego materiału: "+shnumber(Double.toString(pole_c/100))+" m2 blachy. \n";
            String textresult2= "Waga materiału dla stali: "+shnumber(Double.toString(weight))+" kg. \n";
            String textresult3= "Waga materiału dla stali nierdzewnej: "+shnumber(Double.toString(weight_corrosion))+" kg. \n";



            //String textresult = "sd";//String.format("Ilość potrzebnego materiału: %.2d m2 blachy. %n",pole_c);
            //String textresult2 ="asd"; //String.format("asd");
            //String textresult3 = "asd"; //String.format("asd")

            results.appendText(textresult);
            results.appendText(textresult2);
            results.appendText(textresult3);







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
}