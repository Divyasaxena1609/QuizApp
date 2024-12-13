package com.quiz.generator.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.generator.Model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    //Optional<Question> findRandom();
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Question> findRandom();
}
