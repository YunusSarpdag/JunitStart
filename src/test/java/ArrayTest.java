import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {

    @Test
    void testArraysSortMethod(){
        int [] arr1 = {4,1,13,5};
        int [] arr2 = {1,4,5,13};
        Arrays.sort(arr1);
        assertArrayEquals(arr1 , arr2 ,"Not same");
    }

    @Test()
    void testNPE(){
        String name = null;
         assertThrows(NullPointerException.class, ()->{
            System.out.println(name.length());
        });
    }

    @Test()
    @Timeout(1)
    void testSortPerform(){
        int [] arr = {13,2,44};
        for(int i = 0 ; i < 100000; i++){
            Arrays.sort(arr);
        }

        assertTimeout(Duration.ofMillis(10),()->{
            for(int i = 0 ; i < 100000; i++){
                Arrays.sort(arr);
            }
        });
    }
}
