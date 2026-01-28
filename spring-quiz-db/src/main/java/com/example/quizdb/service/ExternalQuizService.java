//This is for the concurrency question, it's a separate folder with questions.

package com.example.quizdb.service;
import com.example.quizdb.entity.Question;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ExternalQuizService {

    @Async
    public CompletableFuture<List<Question>> loadQuestionsAsync() {

        // THREAD.SLEEP PART FOR THE FAKE DELAY
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<Question> questions = List.of(
                new Question(
                        "What is the best-selling board game?",
                        "Monopoly", "Chess", "Scrabble",
                        "Monopoly"
                ),
                new Question(
                        "Which game uses hex tiles and resource trading?",
                        "Catan", "Risk", "Monopoly",
                        "Catan"
                )
        );

        return CompletableFuture.completedFuture(questions);
    }
}
