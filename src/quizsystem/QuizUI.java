import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class QuizUI {

    private Quiz quiz;
    private Label questionLabel;
    private VBox answersBox;
    private Label scoreLabel;

    public QuizUI() {
        quiz = Quiz.loadFromJson("quiz.json");
    }

    public VBox createView() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));

        questionLabel = new Label();
        questionLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        answersBox = new VBox(10);

        scoreLabel = new Label("Score: 0");

        Button nextButton = new Button("Next Question");
        nextButton.setOnAction(e -> showNextQuestion());

        root.getChildren().addAll(questionLabel, answersBox, nextButton, scoreLabel);
        showNextQuestion();

        return root;
    }

    private void showNextQuestion() {
        if (!quiz.hasNext()) {
            questionLabel.setText("Quiz Finished!");
            answersBox.getChildren().clear();
            scoreLabel.setText("Final Score: " + quiz.getScore());
            return;
        }

        Question q = quiz.next();

        questionLabel.setText(q.getText());
        answersBox.getChildren().clear();

        ToggleGroup group = new ToggleGroup();

        for (QuizAnswer answer : q.getAnswers()) {
            RadioButton rb = new RadioButton(answer.getText());
            rb.setToggleGroup(group);
            rb.setOnAction(e -> {
                quiz.submit(answer);
                scoreLabel.setText("Score: " + quiz.getScore());
            });
            answersBox.getChildren().add(rb);
        }
    }
}