package java_quiz.cwcor.exam;

import java_quiz.cwcor.question.Question;
import java_quiz.cwcor.question.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> allQuestions = new ArrayList<>(questionService.getAll());
        if (Math.abs(amount) > allQuestions.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрошено больше вопросов, чем доступно");
        }
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, amount);
    }
}
