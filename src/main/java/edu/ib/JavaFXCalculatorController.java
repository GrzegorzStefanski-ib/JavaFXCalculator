package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.mariuszgromada.math.mxparser.*;

public class JavaFXCalculatorController {

    private final double MAX_TEXT_WIDTH = 250;
    private final double MINIMAL_TEXT_SIZE = 16;
    private final double defaultFontSize = 54;
    private final Font defaultFont = Font.font(defaultFontSize);

    private String regexNumberEnding = ".*[.\\d]$";
    private String regexZeroAsNumber = ".*[^.\\d]0$|^0$";
    private String regexDot = ".*[^.\\d-E]\\d+$|^\\d+$";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField display;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonPM;

    @FXML
    private Button buttonPercent;

    @FXML
    private Button buttonDivide;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonMultiply;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button button0;

    @FXML
    private Button buttonDot;

    @FXML
    private Button buttonEquals;

    @FXML
    private Button exitButton;

    @FXML
    private Button maximizeButton;

    @FXML
    private Button minimizeButton;


    @FXML
    void exitButtonOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void maximaizeButtonOnClick(ActionEvent event) {
        ((Stage)(maximizeButton.getScene().getWindow())).setMaximized(true);
    }

    @FXML
    void minimizeButtonOnClick(ActionEvent event) {
        ((Stage)(minimizeButton.getScene().getWindow())).setIconified(true);
    }


    @FXML
    void button0OnClick(ActionEvent event) {

        if( !Pattern.matches(regexZeroAsNumber, display.getText() )) {
            display.appendText("0");
        }

        display.end();

    }

    @FXML
    void button1OnClick(ActionEvent event) {
        appendNumber("1");
    }

    @FXML
    void button2OnClick(ActionEvent event) {
        appendNumber("2");
    }

    @FXML
    void button3OnClick(ActionEvent event) {
        appendNumber("3");
    }

    @FXML
    void button4OnClick(ActionEvent event) {
        appendNumber("4");
    }

    @FXML
    void button5OnClick(ActionEvent event) {
        appendNumber("5");
    }

    @FXML
    void button6OnClick(ActionEvent event) {
        appendNumber("6");
    }

    @FXML
    void button7OnClick(ActionEvent event) {
        appendNumber("7");
    }

    @FXML
    void button8OnClick(ActionEvent event) {
        appendNumber("8");
    }

    @FXML
    void button9OnClick(ActionEvent event) {
        appendNumber("9");
    }

    @FXML
    void buttonCOnClick(ActionEvent event) {
        display.setText("0");
    }

    public void CE(){
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

    @FXML
    void buttonDotOnClick(ActionEvent event) {
        if( Pattern.matches(regexDot, display.getText() )) {
            display.appendText(".");
        }

        display.end();
    }

    @FXML
    void buttonEqualsOnClick(ActionEvent event) {
        Expression e = new Expression(display.getText());
        display.setText(Double.toString( e.calculate() ));
    }

    @FXML
    void ButtonPercentOnClick(ActionEvent event) {

        if( Pattern.matches(regexNumberEnding, display.getText() )) {

            int i = display.getText().lastIndexOf(" ") + 1;
            Double n = Double.parseDouble(display.getText( i, display.getLength() )) / 100;
            display.replaceText(i, display.getLength(), n.toString());

        }

        display.end();

    }

    @FXML
    void buttonPMOnClick(ActionEvent event) {

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

    @FXML
    void buttonPlusOnClick(ActionEvent event) {
        appendOperation("+");
    }

    @FXML
    void buttonMinusOnClick(ActionEvent event) {
        appendOperation("-");
    }

    @FXML
    void buttonMultiplyOnClick(ActionEvent event) {
        appendOperation("*");
    }

    @FXML
    void ButtonDivideOnClick(ActionEvent event) {
        appendOperation("/");
    }

    private void appendNumber(String number){
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

    private void appendOperation(String operation){
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

    @FXML
    void initialize() {
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonC != null : "fx:id=\"buttonC\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonPM != null : "fx:id=\"buttonPM\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonPercent != null : "fx:id=\"ButtonPercent\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonDivide != null : "fx:id=\"ButtonDivide\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button7 != null : "fx:id=\"button7\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button8 != null : "fx:id=\"button8\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button9 != null : "fx:id=\"button9\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonMultiply != null : "fx:id=\"buttonMultiply\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button4 != null : "fx:id=\"button4\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button5 != null : "fx:id=\"button5\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button6 != null : "fx:id=\"button6\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonMinus != null : "fx:id=\"buttonMinus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonPlus != null : "fx:id=\"buttonPlus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button0 != null : "fx:id=\"button0\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonDot != null : "fx:id=\"buttonDot\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonEquals != null : "fx:id=\"buttonEquals\" was not injected: check your FXML file 'calculator.fxml'.";

        //display.setEditable(false);
        display.setDisable(true);
        maximizeButton.setDisable(true);
        display.setFont(defaultFont);

        display.textProperty().addListener(
                (observable, oldValue, newValue) -> {

            Text text = new Text(newValue);
            text.setFont(defaultFont);

            double textWidth = text.getLayoutBounds().getWidth();

            if (textWidth <= MAX_TEXT_WIDTH) {
                display.setFont(defaultFont);
            }
            else {
                double newFontSize = defaultFontSize * MAX_TEXT_WIDTH / textWidth;

                display.setFont(Font.font(defaultFont.getFamily(),
                        Math.max(newFontSize, MINIMAL_TEXT_SIZE)));
            }

        });

    }

    public Button getButtonC() {
        return buttonC;
    }

    public Button getButtonPM() {
        return buttonPM;
    }

    public Button getButtonPercent() {
        return buttonPercent;
    }

    public Button getButtonDivide() {
        return buttonDivide;
    }

    public Button getButton7() {
        return button7;
    }

    public Button getButton8() {
        return button8;
    }

    public Button getButton9() {
        return button9;
    }

    public Button getButtonMultiply() {
        return buttonMultiply;
    }

    public Button getButton4() {
        return button4;
    }

    public Button getButton5() {
        return button5;
    }

    public Button getButton6() {
        return button6;
    }

    public Button getButtonMinus() {
        return buttonMinus;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Button getButton3() {
        return button3;
    }

    public Button getButtonPlus() {
        return buttonPlus;
    }

    public Button getButton0() {
        return button0;
    }

    public Button getButtonDot() {
        return buttonDot;
    }

    public Button getButtonEquals() {
        return buttonEquals;
    }

}
