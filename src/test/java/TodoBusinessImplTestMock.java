import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TodoBusinessImplTestMock {

    @Test
    void testRetrieveTodosRelatedToSpring(){
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("Admin")).thenReturn(Arrays.asList("Spring" , "Spring.MVC" , "Hibernate"));
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> tmp = todoBusiness.retrieveTodosRelatedToSpring("Admin");
        assertEquals(2 , tmp.size());
    }

    @Test
    void testRetrieveTodosRelatedToSpringNull(){
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("Admin")).thenReturn(Arrays.asList());
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
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