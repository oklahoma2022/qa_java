import Constsnts.ConstantsAnimal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Lion lion;

    public LionTest() {
        lion = Mockito.mock(Lion.class);
    }

    @Test
    public void checkKittens(){
        Mockito.when(lion.getKittens()).thenReturn(1);
        Assert.assertEquals(lion.getKittens(), 1);
    }

    @Test
    public void checkFoodLion() throws Exception {
        List<String> predatorFood = List.of(
            ConstantsAnimal.ANIMALS,
            ConstantsAnimal.BIRDS,
            ConstantsAnimal.FISH
        );

        Mockito.when(lion.getFood()).thenReturn(predatorFood);
        List<String> checkFoodLion = lion.getFood();

        Assert.assertTrue(checkFoodLion.contains(ConstantsAnimal.ANIMALS));
        Assert.assertTrue(checkFoodLion.contains(ConstantsAnimal.BIRDS));
        Assert.assertTrue(checkFoodLion.contains(ConstantsAnimal.FISH));
        Assert.assertFalse(checkFoodLion.contains("Млекопитающие"));
    }

    @Test
    public void checkSex() throws Exception{
        Feline feline = new Feline();

        Lion lionMan = new Lion("Самец", feline);
        Lion lionWoman = new Lion("Самка", feline);

        Assert.assertTrue(lionMan.doesHaveMane());
        Assert.assertFalse(lionWoman.doesHaveMane());
    }

    @Test
    public void checkKittensLion() throws Exception {
        Lion lionMan = new Lion("Самец", new Feline());

        int countKittensLion = lionMan.getKittens();
        Assert.assertEquals(countKittensLion, 1);
    }
}
