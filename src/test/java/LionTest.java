import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTest {

    @Spy
    Feline feline = new Feline();

    @Mock
    Lion mockLion;

    @Test
    public void testLionGetKittensWithoutCount() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedCount = 1;
        int actualCount = lion.getKittens();
        assertEquals(expectedCount,actualCount);
    }

    @Test
    public void testLionGetKittensWithCount() throws Exception {
        Lion lion = new Lion("Самец",feline);
        int expectedCount = 5;
        int actualCount = lion.getKittens(5);
        assertEquals(expectedCount,actualCount);
    }

    @Test
    public void testLionGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = lion.getFood();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testLionWithIncorrectSex() throws Exception {
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> mockLion = new Lion("", feline));
        Assert.assertEquals(expectedMessage,exception.getMessage());

    }
}
