package org.example.quizapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                QuizApplication.class.getResource("quiz-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add(
                QuizApplication.class.getResource("style.css").toExternalForm()
        );

        stage.setTitle("Quiz App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}