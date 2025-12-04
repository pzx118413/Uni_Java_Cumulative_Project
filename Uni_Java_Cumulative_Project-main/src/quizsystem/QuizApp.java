import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizApp extends Application {

    @Override
    public void start(Stage stage) {
        QuizUI quizUI = new QuizUI();
        Scene scene = new Scene(quizUI.createView(), 600, 400);

        stage.setTitle("Quiz Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}