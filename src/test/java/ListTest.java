import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {

    @Test
    void testListSizeMethod(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2);
        assertEquals(2 ,mockList.size());
    }

    @Test
    void testListGetMethod(){
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("Yunus");
        assertEquals("Yunus" , mockList.get(1));
    }

    @Test
    void testListException(){
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenThrow(new RuntimeException("Error"));
        assertThrows(RuntimeException.class, () ->{
            mockList.get(10);
        });
    }

    @Test
    void testMarcher(){
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        assertThat(intList , hasSize(3));
        assertThat(intList , hasItem(1));
        assertThat(intList , everyItem(greaterThan(0)));

        Integer[] intArr = {1,2,3,4};

        assertThat(intArr , arrayWithSize(4));
        assertThat(intArr , hasItemInArray(3));
        assertThat(intArr , arrayContainingInAnyOrder(3 ,2,1));
    }
}
