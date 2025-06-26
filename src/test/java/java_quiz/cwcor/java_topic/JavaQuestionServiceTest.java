package java_quiz.cwcor.java_topic;

import java_quiz.cwcor.models.Question;
import java_quiz.cwcor.services.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;

    @BeforeEach
    void setUp() {
        question1 = "adf";
        answer1 = "adf";
        question2 = "hfgds";
        answer2 = "213";
        javaQuestionService = new JavaQuestionService();
    }


    @Test
    public void add() {
        Question newQuestion = javaQuestionService.add(question1, answer1);
        assertEquals(new Question(question1, answer1), newQuestion);

        Question newQuestion2 = javaQuestionService.add(new Question(question2, answer2));
        assertEquals(new Question(question2, answer2), newQuestion2);
    }

    @Test
    public void remove() {
        javaQuestionService.add(question1, answer1);
        Question delQuestion = javaQuestionService.remove(question1, answer1);
        assertEquals(new Question(question1, answer1), delQuestion);
    }

    @Test
    public void getAll() {
        javaQuestionService.add(question1, answer1);
        javaQuestionService.add(question2, answer2);

        Collection<Question> allQuestions = javaQuestionService.getAll();
        assertEquals(allQuestions.size(), 2);
        assertTrue(allQuestions.contains(new Question(question1, answer1)));
    }

    @Test
    public void getRandomQuestion() {
        javaQuestionService.add(question1, answer1);
        javaQuestionService.add(question2, answer2);

        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertTrue(javaQuestionService.getAll().contains(randomQuestion));
    }
}
