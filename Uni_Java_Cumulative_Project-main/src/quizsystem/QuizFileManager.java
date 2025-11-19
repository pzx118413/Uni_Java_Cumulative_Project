package quizsystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class QuizFileManager {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Answer.class, new AnswerAdapter())
            .setPrettyPrinting()
            .create();

    // SAVE QUIZ TO JSON
    public static void saveQuiz(QuizImpl<QuizQuestion> quiz, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(quiz, writer);
            System.out.println("Quiz successfully saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving quiz: " + e.getMessage());
        }
    }

    // LOAD QUIZ FROM JSON
    public static QuizImpl<QuizQuestion> loadQuiz(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            java.lang.reflect.Type quizType =
                    new com.google.gson.reflect.TypeToken<QuizImpl<QuizQuestion>>() {}.getType();

            return gson.fromJson(reader, quizType);

        } catch (IOException e) {
            System.out.println("Error loading quiz: " + e.getMessage());
            return null;
        }
    }
}