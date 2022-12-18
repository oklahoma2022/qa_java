import Constsnts.ConstantsAnimal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    Feline feline;
    private final int actualValue;
    private final int expectedValue;
    private final boolean expectedResult;

    public FelineTest(int actualValue, int expectedValue, boolean expectedResult) {
        feline = new Feline();
        this.actualValue = actualValue;
        this.expectedValue = expectedValue;
        this.expectedResult = expectedResult;
    }

    @Test
    public void checkFamily(){
        String animalFamily = feline.getFamily();

        Assert.assertEquals(animalFamily,  ConstantsAnimal.CATS);
        Assert.assertNotEquals(animalFamily, "Собачьи");

    }

    @Parameters
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
    public void checkDefaultKittens() {
        int countKittens = feline.getKittens();
        Assert.assertEquals(countKittens, 1);
    }

    @Test
    public void checkKittens(){
        int countKittens = feline.getKittens(actualValue);

        if (expectedResult) {
            Assert.assertEquals(countKittens, expectedValue);
        } else {
            Assert.assertNotEquals(countKittens, expectedValue);
        }
    }

    @Test
    public void checkFood() throws Exception {
        List<String> animalsTypes = feline.eatMeat();

        Assert.assertTrue(animalsTypes.contains(ConstantsAnimal.ANIMALS));
        Assert.assertTrue(animalsTypes.contains(ConstantsAnimal.BIRDS));
        Assert.assertTrue(animalsTypes.contains(ConstantsAnimal.FISH));
        Assert.assertFalse(animalsTypes.contains("Млекопитающие"));
    }
}
