import com.example.Animal;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertThrows;

public class AnimalTest {

    Animal testAnimal = new Animal();

    @Test
    public void predatorTest() throws Exception {
        List<String> actual = testAnimal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void herbivoresTest() throws Exception {
        List<String> actual = testAnimal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exceptionTest() {
        String anotherAnimal = "Блохэй";
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = assertThrows(Exception.class, () -> {
            testAnimal.getFood(anotherAnimal);
        });
        String actualMessage = exception.getMessage();
        boolean actual = actualMessage.contains(expectedMessage);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void getFamilyTest(){
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = testAnimal.getFamily();
        Assert.assertEquals(expected, actual);
    }
}
