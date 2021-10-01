import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    static  StringHelper helper;
    @BeforeAll
    static void beforeAll() {
        System.out.println("start");
        helper = new StringHelper();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("end");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Before All Method");
    }

    @AfterEach
    void tearDown(){
        System.out.println("After All Method");
    }

    @Test
    void testTruncateAInFirst2Positions(){
        assertAll("heading",
                ()-> assertEquals(helper.truncateAInFirst2Positions("AAMC") , "MC"),
                ()-> assertEquals(helper.truncateAInFirst2Positions("ABC") , "BC"),
                ()-> assertEquals(helper.truncateAInFirst2Positions("BBA") , "BBA"));
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame(){
        assertAll("heading",
                ()-> assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABED")),
                ()-> assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB")));
    }

    @ParameterizedTest
    @CsvSource(value ={
            "AAMC , MC" , "ABC , BC"
    })
    void parameterizedTest(String input, String expected){
        assertEquals(expected , helper.truncateAInFirst2Positions(input));
    }

}