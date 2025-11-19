package quizsystem;

import java.util.ArrayList;
import java.util.List;

public class QuizImpl<T extends Question> implements Quiz<T> {

    private List<T> questions;

    public QuizImpl() {
        questions = new ArrayList<>();
    }

    @Override
    public void addQuestion(T question) {
        questions.add(question);
    }

    @Override
    public T getQuestion(int index) {
        return questions.get(index);
    }

    @Override
    public int size() {
        return questions.size();
    }
}
