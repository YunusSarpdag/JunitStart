import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoBusinessImplTestMockAnnotation {

    @Mock TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusiness;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    void testRetrieveTodosRelatedToSpring(){
        when(todoService.retrieveTodos("Admin")).thenReturn(Arrays.asList("Spring" , "Spring.MVC" , "Hibernate"));
        List<String> tmp = todoBusiness.retrieveTodosRelatedToSpring("Admin");
        assertEquals(2 , tmp.size());
    }

    @Test
    void testRetrieveTodosRelatedToSpringNull(){
        when(todoService.retrieveTodos("Admin")).thenReturn(Arrays.asList());
        List<String> tmp = todoBusiness.retrieveTodosRelatedToSpring("Admin");
        assertEquals(0 , tmp.size());

        verify(todoService).retrieveTodos("Admin");
        verify(todoService, times(1)).retrieveTodos("Admin");
        verify(todoService, times(0)).deleteTodo("Admin");
        verify(todoService , never()).deleteTodo("Admin");

        verify(todoService).retrieveTodos(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue() , "Admin");
        assertEquals(argumentCaptor.getAllValues().size() , 1);

    }
}