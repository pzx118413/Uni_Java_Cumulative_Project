package quizsystem;

public interface Quiz<T extends Question> {
    void addQuestion(T question);
    T getQuestion(int index);
    int size();
}
