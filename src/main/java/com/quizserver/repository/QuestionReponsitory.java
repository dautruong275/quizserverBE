package com.quizserver.repository;

import com.quizserver.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionReponsitory extends JpaRepository<Question, Long> {
}