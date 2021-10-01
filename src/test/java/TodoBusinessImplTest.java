import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoBusinessImplTest {

    @Test
    void testRetrieveTodosRelatedToSpring(){
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> tmp = todoBusiness.retrieveTodosRelatedToSpring("Admin");
        assertEquals(2 , tmp.size());
    }
}