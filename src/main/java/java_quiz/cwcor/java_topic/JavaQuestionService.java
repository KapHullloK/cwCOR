package java_quiz.cwcor.java_topic;

import java_quiz.cwcor.question.Question;
import java_quiz.cwcor.question.QuestionService;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Primary
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQ = new Question(question, answer);
        this.questions.add(newQ);
        return newQ;
    }

    @Override
    public Question remove(Question question) {
        this.questions.remove(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question newQ = new Question(question, answer);
        this.questions.remove(newQ);
        return newQ;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "список вопросов пуст");
        }
        List<Question> listQ = new ArrayList<>(questions);
        int ind = new Random().nextInt(listQ.size());
        return listQ.get(ind);
    }
}
