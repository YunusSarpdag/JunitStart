import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Spring" , "Spring.MVC" , "Hibernate");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
