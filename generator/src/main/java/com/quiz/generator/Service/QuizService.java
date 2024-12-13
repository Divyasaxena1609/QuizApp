package com.quiz.generator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.generator.Model.Answer;
import com.quiz.generator.Model.Question;
import com.quiz.generator.Model.QuizSession;
import com.quiz.generator.Repository.AnswerRepository;
import com.quiz.generator.Repository.QuestionRepository;
import com.quiz.generator.Repository.QuizSessionRepository;

@Service
public class QuizService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    // Start a new quiz session
    public QuizSession startQuiz(Long userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        return quizSessionRepository.save(session);
    }

    // Get a random question from the database
    public Question getRandomQuestion() {
        return questionRepository.findRandom().orElseThrow(() -> new RuntimeException("No questions available"));
    }

    // Submit an answer
    public Answer submitAnswer(Long quizSessionId, Long questionId, String answerText) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        boolean isCorrect = question.getCorrectAnswer().equals(answerText);

        Answer answer = new Answer();
        answer.setQuizSessionId(quizSessionId);
        answer.setQuestionId(questionId);
        answer.setAnswerText(answerText);
        answer.setCorrect(isCorrect);
        
        // Update the quiz session with correct/incorrect answer counts
        QuizSession session = quizSessionRepository.findById(quizSessionId)
                .orElseThrow(() -> new RuntimeException("Quiz session not found"));

        if (isCorrect) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }
        session.setTotalQuestionsAnswered(session.getTotalQuestionsAnswered() + 1);
        quizSessionRepository.save(session);

        return answerRepository.save(answer);
    }

    // Get the statistics of answered questions for the user
    public QuizSession getQuizStats(Long userId) {
        QuizSession session = quizSessionRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Quiz session not found"));
        return session;
    }
}

