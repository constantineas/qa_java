import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CatWitoutParamTest {


    @Mock
    Feline feline;

    Cat cat;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() throws Exception {
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals(expected, actual);
    }
}
