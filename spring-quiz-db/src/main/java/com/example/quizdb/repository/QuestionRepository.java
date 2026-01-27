package com.example.quizdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.quizdb.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}