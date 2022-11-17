import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class CatTest {

    @Mock
    Feline feline;

    Cat cat;

    private final String animals;
    private final int count;

    public CatTest(String animals, int count){
        this.animals = animals;
        this.count = count;
    }

    @Parameterized.Parameters
    public static Object[] getData(){
        return new Object[][]{
                {"Животные", 0},
                {"Птицы", 1},
                {"Рыба", 2},
        };
    }

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
        cat = new Cat(feline);
    }



    @Test
    public void getFoodTest() throws Exception{
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = cat.getFood();
        String expected = animals;
        String actual = food.get(count);
        Assert.assertEquals(expected, actual);
    }
}
