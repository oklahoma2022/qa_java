import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FelineParametersTest {

    Feline feline;
    private final int actualValue;
    private final int expectedValue;
    private final boolean expectedResult;

    public FelineParametersTest(int actualValue, int expectedValue, boolean expectedResult){
        feline = new Feline();
        this.actualValue = actualValue;
        this.expectedValue = expectedValue;
        this.expectedResult = expectedResult;
    }


    @Parameters(name = "Тестовые данные: Кол-во передаваемое: {0}, ожидаемое кол-во: {1}, ожидаемый результат: {2}")
    public static Object[][] getKittensAll() {
        return new Object[][]{
                {-1, 0, false}, //  негативный кейс, отрицательное число котиков  быть не может
                {0, 0, true}, // позитивный кейс , значение 0 котиков (котиков нет) возможно . по тз нет органичений
                {1, 0, false},// проверка если кол-во котиков 1 не соотвествует ожидаему нами "нет котиков" - 0
                {1, 1, true}, // позитианый кейс , кол-во котиков 1 и равно 1-му!
                {10, 10, true}, // позитианый кейс 10 котиков передаем, столько же и ожидаем
        };
    };

    @Test
    public void checkKittens() {
        int countKittens = feline.getKittens(actualValue);

        if (expectedResult) {
            Assert.assertEquals(countKittens, expectedValue);
        } else {
            Assert.assertNotEquals(countKittens, expectedValue);
        }
    }
}