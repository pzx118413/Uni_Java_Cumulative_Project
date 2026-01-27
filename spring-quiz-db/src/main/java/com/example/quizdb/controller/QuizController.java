package com.example.quizdb.controller;

import com.example.quizdb.entity.Question;
import com.example.quizdb.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("score")
public class QuizController {

    private final QuestionRepository questionRepository;

    public QuizController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @ModelAttribute("score")
    public Integer score() {
        return 0;
    }

    @GetMapping("/")
    public String showQuiz(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "quiz";
    }

    @PostMapping("/answer")
    public String checkAnswer(
            @RequestParam Long questionId,
            @RequestParam String chosenAnswer,
            @ModelAttribute("score") Integer score,
            Model model
    ) {
        Question question = questionRepository.findById(questionId).orElseThrow();

        boolean correct = question.getAnswer().equalsIgnoreCase(chosenAnswer);

        if (correct) {
            score++; // increase score, BUT don't click on the same answer multiple times please
        }

        model.addAttribute("score", score);
        model.addAttribute("questions", questionRepository.findAll());
        model.addAttribute("answeredQuestionId", questionId);
        model.addAttribute("result", correct ? "Correct answer" : "Wrong answer");
        model.addAttribute("resultColor", correct ? "correct" : "wrong");

        return "quiz";
    }
}
