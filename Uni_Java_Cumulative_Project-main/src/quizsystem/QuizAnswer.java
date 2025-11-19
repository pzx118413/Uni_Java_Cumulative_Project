package quizsystem;

public class QuizAnswer implements Answer {

    private String text;

    public QuizAnswer(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
