import Constsnts.ConstantsAnimal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

public class FelineTest {
    Feline feline;

    public FelineTest() {
        feline = new Feline();
    }

    @Test
    public void checkFamily(){
        String animalFamily = feline.getFamily();

        Assert.assertEquals(animalFamily,  ConstantsAnimal.CATS);
        Assert.assertNotEquals(animalFamily, "Собачьи");

    }

    @Test
    public void checkDefaultKittens() {
        int countKittens = feline.getKittens();
        Assert.assertEquals(countKittens, 1);
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
