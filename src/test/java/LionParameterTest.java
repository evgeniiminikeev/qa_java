import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class LionParameterTest {
    private final String gender;
    private final Boolean expectedResult;

    public LionParameterTest(String gender, Boolean expectedResult) {
        this.gender = gender;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getGender() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Spy
    Feline feline = new Feline();

    @Test
    public void testLionSex() throws Exception {
        Lion lion = new Lion(gender, feline);
        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }
}
