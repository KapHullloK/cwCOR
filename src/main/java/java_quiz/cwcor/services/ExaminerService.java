package java_quiz.cwcor.services;

import java_quiz.cwcor.models.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
