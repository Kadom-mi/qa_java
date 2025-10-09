import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String GENDER_MALE = "Самец";
    private static final String GENDER_FEMALE = "Самка";
    private static final String INVALID_SEX = "Неверный пол";

    private Lion lion;

    @Spy
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(GENDER_MALE, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testMaleLionHasMane() throws Exception {
        lion = new Lion(GENDER_MALE, new Feline());
        assertTrue("Самец льва должен иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionDoesNotHaveMane() throws Exception {
        lion = new Lion(GENDER_FEMALE, new Feline());
        assertFalse("Самка льва не должна иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testInvalidSex() throws Exception {
        try {
            lion = new Lion(INVALID_SEX, new Feline());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(GENDER_MALE, feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}
