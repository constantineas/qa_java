import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class FelineTest {

    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception{
        List<String> expected = feline.eatMeat();
        List<String> actual = feline.getFood("Хищник");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFamilyTest() throws Exception {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() throws Exception {
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensParamTest() throws Exception {
        int expected = 20;
        int actual = feline.getKittens(20);
        Assert.assertEquals(expected, actual);
    }

}
