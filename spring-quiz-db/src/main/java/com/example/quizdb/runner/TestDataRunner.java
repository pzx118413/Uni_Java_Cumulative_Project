package com.example.quizdb.runner;

import com.example.quizdb.entity.Question;
import com.example.quizdb.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDataRunner {

    @Bean
    CommandLineRunner run(QuestionRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Question(
                        "What is the best-selling board game?",
                        "Monopoly",
                        "Chess",
                        "Scrabble",
                        "Monopoly" // correct answer
                ));
                repo.save(new Question(
                        "Which board game features properties and rent?",
                        "Monopoly",
                        "Catan",
                        "Risk",
                        "Monopoly"
                ));
                repo.save(new Question(
                        "Which game uses hex tiles and resource trading?",
                        "Catan",
                        "Monopoly",
                        "Chess",
                        "Catan"
                ));
            }
        };
    }
}
