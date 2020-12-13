package edu.ib;

import javafx.scene.control.TextField;
import org.mariuszgromada.math.mxparser.Expression;

import java.util.regex.Pattern;

public class CalculatorModel {

    private String regexNumberEnding = ".*[.\\d]$";
    private String regexZeroAsNumber = ".*[^.\\d]0$|^0$";
    private String regexDot = ".*[^.\\d-E]\\d+$|^\\d+$";

    public void appendNumber(String number, TextField display){

        if(number.compareTo("0") == 0){
            if( !Pattern.matches(regexZeroAsNumber, display.getText() )) {
                display.appendText("0");
            }

            display.end();
            return;
        }

        if( Pattern.matches(regexZeroAsNumber, display.getText() )) {
            display.replaceText(
                    display.getLength() - 1,
                    display.getLength(),
                    number
            );
        }
        else {
            display.appendText(number);
        }

        display.end();
    }

    public void appendOperation(String operation, TextField display){
        if( Pattern.matches(regexNumberEnding, display.getText() )) {
            display.appendText(" " + operation + " ");
        }
        else {
            display.replaceText(
                    display.getLength() - 2,
                    display.getLength() - 1,
                    operation
            );
        }

        display.end();
    }

    public void plusMinus(TextField display){
        if( Pattern.matches(regexNumberEnding, display.getText() )) {

            if (!display.getText().contains(" ")){

                Double n = Double.parseDouble(display.getText()) * -1;
                display.setText(n.toString());
                display.end();
                return;

            }

            int i = display.getText().lastIndexOf(" ");

            if( display.getText(i + 1, i + 2).compareTo("-") == 0 ) {
                display.replaceText(i + 1, i + 2, "");
            }
            else {
                display.replaceText(i , i + 1, " -");
            }

            display.end();

        }
    }

    public void percent(TextField display){

        if( Pattern.matches(regexNumberEnding, display.getText() )) {

            int i = display.getText().lastIndexOf(" ") + 1;
            Double n = Double.parseDouble(display.getText( i, display.getLength() )) / 100;
            display.replaceText(i, display.getLength(), n.toString());

        }

        display.end();
    }

    public void equals(TextField display){
        Expression e = new Expression(display.getText());
        display.setText(Double.toString( e.calculate() ));
    }

    public void dot(TextField display) {
        if( Pattern.matches(regexDot, display.getText() )) {
            display.appendText(".");
        }

        display.end();
    }

    public void CE(TextField display){
        if(!display.getText().isBlank()){

            if(display.getText().endsWith(" ")){
                display.deleteText(
                        display.getLength() - 3,
                        display.getLength()
                );
            }
            else {
                display.deleteText(
                        display.getLength() - 1,
                        display.getLength()
                );
            }

        }

        display.end();
    }

    public void C(TextField display){
        display.setText("0");
    }
}
