package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXCalculatorController {

    CalculatorModel cm = new CalculatorModel();

    private final double MAX_TEXT_WIDTH = 250;
    private final double MINIMAL_TEXT_SIZE = 16;
    private final double defaultFontSize = 54;
    private final Font defaultFont = Font.font(defaultFontSize);

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
        cm.appendNumber("0", display);
    }

    @FXML
    void button1OnClick(ActionEvent event) {
        cm.appendNumber("1", display);
    }

    @FXML
    void button2OnClick(ActionEvent event) {
        cm.appendNumber("2", display);
    }

    @FXML
    void button3OnClick(ActionEvent event) {
        cm.appendNumber("3", display);
    }

    @FXML
    void button4OnClick(ActionEvent event) {
        cm.appendNumber("4", display);
    }

    @FXML
    void button5OnClick(ActionEvent event) {
        cm.appendNumber("5", display);
    }

    @FXML
    void button6OnClick(ActionEvent event) {
        cm.appendNumber("6", display);
    }

    @FXML
    void button7OnClick(ActionEvent event) {
        cm.appendNumber("7", display);
    }

    @FXML
    void button8OnClick(ActionEvent event) {
        cm.appendNumber("8", display);
    }

    @FXML
    void button9OnClick(ActionEvent event) {
        cm.appendNumber("9", display);
    }

    @FXML
    void buttonCOnClick(ActionEvent event) {
        cm.C(display);
    }

    public void CE() {
        cm.CE(display);
    }

    @FXML
    void buttonDotOnClick(ActionEvent event) {
        cm.dot(display);
    }

    @FXML
    void buttonEqualsOnClick(ActionEvent event) {
        cm.equals(display);
    }

    @FXML
    void ButtonPercentOnClick(ActionEvent event) {
        cm.percent(display);
    }

    @FXML
    void buttonPMOnClick(ActionEvent event) {
        cm.plusMinus(display);
    }

    @FXML
    void buttonPlusOnClick(ActionEvent event) {
        cm.appendOperation("+", display);
    }

    @FXML
    void buttonMinusOnClick(ActionEvent event) {
        cm.appendOperation("-", display);
    }

    @FXML
    void buttonMultiplyOnClick(ActionEvent event) {
        cm.appendOperation("*", display);
    }

    @FXML
    void ButtonDivideOnClick(ActionEvent event) {
        cm.appendOperation("/", display);
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
