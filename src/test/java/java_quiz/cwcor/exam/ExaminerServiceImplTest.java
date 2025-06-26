package java_quiz.cwcor.exam;

import java_quiz.cwcor.models.Question;
import java_quiz.cwcor.services.QuestionService;
import java_quiz.cwcor.services.ExaminerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;
    private ExaminerServiceImpl examinerServiceImpl;
    private Question q1;
    private Question q2;

    @BeforeEach
    void setUp() {
        q1 = new Question("asdg", "123");
        q2 = new Question("gfsa", "63");
        examinerServiceImpl = new ExaminerServiceImpl(questionService);
        Mockito.when(questionService.getAll()).thenReturn(List.of(q1, q2));
        Mockito.when(questionService.getRandomQuestion()).thenReturn(q1).thenReturn(q2);
    }

    @Test
    public void getQuestions() {
        Collection<Question> questions = examinerServiceImpl.getQuestions(2);
        assertTrue(questions.contains(q1));
        assertTrue(questions.contains(q2));
    }
}
