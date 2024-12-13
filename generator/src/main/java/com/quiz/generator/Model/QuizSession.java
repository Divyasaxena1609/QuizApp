package com.quiz.generator.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private int totalQuestionsAnswered = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    public QuizSession() {
        //
    }

    public QuizSession(Long id, Long userId, int totalQuestionsAnswered, int correctAnswers, int incorrectAnswers) {
        this.id = id;
        this.userId = userId;
        this.totalQuestionsAnswered = totalQuestionsAnswered;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }
    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }
    public int getCorrectAnswers() {
        return correctAnswers;
    }
    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }
    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    // Getters and setters
    
}
