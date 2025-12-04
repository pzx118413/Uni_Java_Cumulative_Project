package quizsystem;

import java.util.List;

public interface Question {
    String getQuestionText();
    List<Answer> getAnswers();
    boolean isCorrect(int index);
}
