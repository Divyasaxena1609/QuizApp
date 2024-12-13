package com.quiz.generator.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quizSessionId;
    private Long questionId;
    private String answerText;
    private boolean isCorrect;

    public Answer() {
        //
    }

    public Answer(Long id, Long quizSessionId, Long questionId, String answerText, boolean isCorrect) {
        this.id = id;
        this.quizSessionId = quizSessionId;
        this.questionId = questionId;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getQuizSessionId() {
        return quizSessionId;
    }
    public void setQuizSessionId(Long quizSessionId) {
        this.quizSessionId = quizSessionId;
    }
    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    public String getAnswerText() {
        return answerText;
    }
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
    public boolean isCorrect() {
        return isCorrect;
    }
    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

}
