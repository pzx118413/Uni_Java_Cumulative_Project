package quizsystem;

public class QuizTest {
    public static void main(String[] args) {
        QuizImpl<QuizQuestion> quiz = new QuizImpl<>();

        QuizQuestion q = new QuizQuestion("What is the best-selling board game of all time?", 1);
        q.addAnswer(new QuizAnswer("Monopoly"));
        q.addAnswer(new QuizAnswer("Chess"));
        q.addAnswer(new QuizAnswer("Scrabble"));

        quiz.addQuestion(q);
        QuizFileManager.saveQuiz(quiz, "quiz.json");
        QuizImpl<QuizQuestion> loadedQuiz = QuizFileManager.loadQuiz("quiz.json");

        System.out.println("Loaded quiz question: " +
                loadedQuiz.getQuestion(0).getQuestionText());
    }
}