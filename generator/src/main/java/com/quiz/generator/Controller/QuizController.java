package com.quiz.generator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.generator.Model.Answer;
import com.quiz.generator.Model.Question;
import com.quiz.generator.Model.QuizSession;
import com.quiz.generator.Service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Endpoint to start a new quiz session
    @PostMapping("/start")
    public ResponseEntity<QuizSession> startQuiz(@RequestParam Long userId) {
        QuizSession session = quizService.startQuiz(userId);
        return ResponseEntity.ok(session);
    }

    // Endpoint to get a random question
    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        Question question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }

    // Endpoint to submit an answer
    @PostMapping("/submit")
    public ResponseEntity<Answer> submitAnswer(
            @RequestParam Long quizSessionId,
            @RequestParam Long questionId,
            @RequestParam String answerText) {
        Answer answer = quizService.submitAnswer(quizSessionId, questionId, answerText);
        return ResponseEntity.ok(answer);
    }

    // Endpoint to get the quiz statistics (answered questions, correct/incorrect answers)
    @GetMapping("/stats")
    public ResponseEntity<QuizSession> getQuizStats(@RequestParam Long userId) {
        QuizSession session = quizService.getQuizStats(userId);
        return ResponseEntity.ok(session);
    }
}

