import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class LionExceptionTest {

    Feline feline;
    Lion lion;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void exceptionTest() throws Exception {
        String sex = "Самцы";
        String expectedMess = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows(Exception.class, () -> {
            lion = new Lion(sex, feline);
        });
        String actualMess = exception.getMessage();
        boolean actual = actualMess.contains(expectedMess);
        Assert.assertEquals(true, actual);
    }
}
