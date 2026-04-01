package com.quiz;

import com.quiz.entities.Quiz;
import com.quiz.repositoty.QuizRepo;
import com.quiz.services.QuizServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    QuizRepo quizRepo;
    @InjectMocks
    QuizServiceImpl quizService;

    @BeforeAll
    public static void init(){
      System.out.println("before all");
      // for like operation db connection , DB setup
  }
    @BeforeEach
    public void initBefore(){
        System.out.println("before each method");
        // Executed after each and every test
    }

    @AfterAll
   public static void distroy(){
       System.out.println("After all");
       // for like distroy db connectin
   }

     @AfterEach
   public void cleanupOrReseting(){
       System.out.println("After Each");
       // for like reassinging  the value after each test
   }
    @Test
    public void testTheAddMethodInServiceImpl(){
        Quiz quiz= new Quiz();
        quiz.setId(1l);
        quiz.setTitle("test title");
        when(quizRepo.save(quiz)).thenReturn(quiz);
        Quiz returningQuiz=quizService.add(quiz);
        System.out.println("add method is testing !");
        // returnQuiz==currentQuiz

        assertEquals(quiz.getId(),returningQuiz.getId());
        assertNotNull(returningQuiz);
        assertEquals(quiz.getTitle(),returningQuiz.getTitle());
    }
     @Test
     public  void deleteProduct(){
        doNothing().when(quizRepo).deleteById((long)1);
          quizService.deleteQuiz((long)1);
        verify(quizRepo,times(1)).deleteById((long)1);
    }
}
