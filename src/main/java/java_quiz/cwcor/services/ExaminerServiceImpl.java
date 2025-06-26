package java_quiz.cwcor.services;

import java_quiz.cwcor.models.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (Math.abs(amount) > questionService.getAll().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрошено больше вопросов, чем доступно");
        }

        Set<Question> responseQ = new HashSet<>();
        while (responseQ.size() < amount) {
            responseQ.add(questionService.getRandomQuestion());
        }

        return responseQ;
    }
}
