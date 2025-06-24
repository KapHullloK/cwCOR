package java_quiz.cwcor.exam;

import java_quiz.cwcor.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
