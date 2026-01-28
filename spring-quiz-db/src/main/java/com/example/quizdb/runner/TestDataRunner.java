package com.example.quizdb.runner;

import com.example.quizdb.entity.Question;
import com.example.quizdb.repository.QuestionRepository;
import com.example.quizdb.service.ExternalQuizService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Configuration
public class TestDataRunner {

    @Bean
    CommandLineRunner run(
            QuestionRepository repo,
            ExternalQuizService externalQuizService
    ) {
        return args -> {

            if (repo.count() == 0) {

                //Concurrency is here (arrow down if I had the emoji)
                CompletableFuture<List<Question>> future =
                        externalQuizService.loadQuestionsAsync();

                List<Question> questions = future.join();

                repo.saveAll(questions);

                System.out.println("Quiz data loaded asynchronously.");
            }
        };
    }

}
