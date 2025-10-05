import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {

    private static final String UNSUPPORTED_ANIMAL = "Неизвестный вид";
    private static final String EXCEPTION_FAMILY = "Неизвестный вид животного, " +
            "используйте значение Травоядное или Хищник";
    private static final String EXPECTED_FAMILY = "Существует несколько семейств: " +
            "заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    private Animal animal;

    @Before
    public void createNewAnimal() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> animalPredator = animal.getFood("Хищник");
        List<String> expectedFoodPredator = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Неверный список еды для Хищника", expectedFoodPredator, animalPredator);

        List<String> animalHerbivore = animal.getFood("Травоядное");
        List<String> expectedFoodHerbivore = List.of("Трава", "Различные растения");
        assertEquals("Неверный список еды для Травоядного", expectedFoodHerbivore, animalHerbivore);

        try {
            animal.getFood(UNSUPPORTED_ANIMAL);
        } catch (Exception e) {
            System.out.println(EXCEPTION_FAMILY);
        }
    }

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();

        assertEquals("Неверный список семейств животных",
                EXPECTED_FAMILY, actual);
    }
}

