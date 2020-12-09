package edu.ib;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class JavaFXCalculator extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        stage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/calculator.fxml"));
        Parent root = loader.load();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene= new Scene(root,300,400);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        JavaFXCalculatorController controller = loader.getController();

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            public void handle(KeyEvent ke) {

                switch (ke.getCode()) {

                    case ENTER:
                        controller.getButtonEquals().fire();
                        break;

                    case DIGIT0:
                    case NUMPAD0:
                        controller.getButton0().fire();
                        break;

                    case DIGIT1:
                    case NUMPAD1:
                        controller.getButton1().fire();
                        break;

                    case DIGIT2:
                    case NUMPAD2:
                        controller.getButton2().fire();
                        break;

                    case DIGIT3:
                    case NUMPAD3:
                        controller.getButton3().fire();
                        break;

                    case DIGIT4:
                    case NUMPAD4:
                        controller.getButton4().fire();
                        break;

                    case DIGIT5:
                        if(ke.isShiftDown()){
                            controller.getButtonPercent().fire();
                            break;
                        }
                    case NUMPAD5:
                        controller.getButton5().fire();
                        break;

                    case DIGIT6:
                    case NUMPAD6:
                        controller.getButton6().fire();
                        break;

                    case DIGIT7:
                    case NUMPAD7:
                        controller.getButton7().fire();
                        break;

                    case DIGIT8:
                        if(ke.isShiftDown()){
                            controller.getButtonMultiply().fire();
                            break;
                        }
                    case NUMPAD8:
                        controller.getButton8().fire();
                        break;

                    case DIGIT9:
                    case NUMPAD9:
                        controller.getButton9().fire();
                        break;

                    case ADD:
                    case PLUS:
                    case EQUALS:
                        controller.getButtonPlus().fire();
                        break;

                    case SUBTRACT:
                    case MINUS:
                        controller.getButtonMinus().fire();
                        break;

                    case DIVIDE:
                    case SLASH:
                        controller.getButtonDivide().fire();
                        break;

                    case ASTERISK:
                    case MULTIPLY:
                        controller.getButtonMultiply().fire();
                        break;

                    case BACK_SPACE:
                        controller.CE();
                        break;

                    case PERIOD:
                    case DELETE:
                        controller.getButtonDot().fire();
                        break;

                }

            }

        });


        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
