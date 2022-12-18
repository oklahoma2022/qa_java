import Constsnts.ConstantsAnimal;
import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class CatTest {
    Feline feline;
    Cat cat;

    public CatTest() {
        feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void checkSound() {
        String checkSoundCat  = cat.getSound();
        Assert.assertEquals(checkSoundCat, "Мяу");
        Assert.assertNotEquals(checkSoundCat, "Гав");
    }

    @Test
    public void checkFood() throws Exception {
        List<String> checkFoodCat = cat.getFood();

        Assert.assertTrue(checkFoodCat.contains(ConstantsAnimal.ANIMALS));
        Assert.assertTrue(checkFoodCat.contains(ConstantsAnimal.BIRDS));
        Assert.assertTrue(checkFoodCat.contains(ConstantsAnimal.FISH));
        Assert.assertFalse(checkFoodCat.contains("Млекопитающие"));
    }
}
