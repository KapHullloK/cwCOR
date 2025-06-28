package java_quiz.cwcor.services;

import java_quiz.cwcor.models.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);

    Question add(String question, String answer);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
