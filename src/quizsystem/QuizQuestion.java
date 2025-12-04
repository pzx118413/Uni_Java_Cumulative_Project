package quizsystem;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion implements Question {

    private String questionText;
    private List<Answer> answers;
    private int correctIndex;

    public QuizQuestion(String questionText, int correctIndex) {
        this.questionText = questionText;
        this.correctIndex = correctIndex;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public boolean isCorrect(int index) {
        return index == correctIndex;
    }
}
