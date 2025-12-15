package org.example.quizapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class QuizController {

    @FXML
    private Label questionLabel;

    @FXML
    private VBox answersBox;

    @FXML
    private Button skipButton;

    private int currentQuestion = 0;

    private final List<String> questions = List.of(
            "What is the best-selling board game of all time?",
            "Which board game involves buying and trading properties?",
            "In Chess, which piece can only move diagonally?"
    );

    private final List<List<String>> answers = List.of(
            List.of("Monopoly", "Chess", "Scrabble"),
            List.of("Monopoly", "Risk", "Cluedo"),
            List.of("Bishop", "Knight", "Rook")
    );

    @FXML
    public void initialize() {
        loadQuestion();
    }

    private void loadQuestion() {
        questionLabel.setText(questions.get(currentQuestion));
        answersBox.getChildren().clear();

        List<String> currentAnswers = answers.get(currentQuestion);

        for (int i = 0; i < currentAnswers.size(); i++) {
            String answer = currentAnswers.get(i);
            Button btn = new Button(answer);
            btn.getStyleClass().add("answer-button");
            btn.setMaxWidth(Double.MAX_VALUE);

            final boolean isCorrect = (i == 0);

            btn.setOnAction(e -> {
                if (isCorrect) {
                    score++;
                    scoreLabel.setText("Score: " + score);
                }
                skipButton.fire();
            });

            answersBox.getChildren().add(btn);
        }
    }

    @FXML
    private void nextQuestion() {
        currentQuestion++;

        if (currentQuestion >= questions.size()) {
            questionLabel.setText("Quiz finished!");
            answersBox.getChildren().clear();
            skipButton.setText("Start Again");
            skipButton.setOnAction(e -> restartQuiz());
        } else {
            loadQuestion();
        }
    }
    private void restartQuiz() {
        score = 0;
        scoreLabel.setText("Score: 0");
        currentQuestion = 0;
        skipButton.setText("Skip Question");
        skipButton.setOnAction(e -> nextQuestion());
        loadQuestion();
    }
    @FXML
    private Label scoreLabel;

    private int score = 0;

}