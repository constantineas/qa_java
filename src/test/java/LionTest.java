import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(value = Parameterized.class)
public class LionTest {

    Feline feline;
    Lion lion;

    @Before
    public void init() {
        feline = new Feline();
    }
    private final String sex;
    private final String animals;
    private final boolean expected;



    public LionTest(String sex, String animals, boolean expected) {
        this.sex = sex;
        this.animals = animals;
        this.expected = expected;

    }

    @Parameterized.Parameters
    public static Object[] getSumData()
    {
        return new Object[][]
                {// передали тестовые данные
                        {"Самец", "Хищник", true},
                        {"Самка", "Хищник", false},
                };
    }

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion(sex, feline);
        int expectedKittensCount = 1;
        int actual = lion.getKittens();
        Assert.assertEquals(expectedKittensCount, actual);
    }

    @Test
    public void eatMeatTest() throws Exception {
        lion = new Lion(sex, feline);
        List<String> expectedFood = feline.getFood(animals);
        List<String> actual = lion.getFood();
        Assert.assertEquals(expectedFood, actual);
    }

    @Test
    public void isDoHaveSexTest() throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }



}
