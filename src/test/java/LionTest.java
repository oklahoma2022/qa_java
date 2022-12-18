import Constsnts.ConstantsAnimal;
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
    public void checkFood() throws Exception {
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
        Lion lionMan = new Lion("Самец");
        Lion lionWoman = new Lion("Самка");

        Assert.assertTrue(lionMan.doesHaveMane());
        Assert.assertFalse(lionWoman.doesHaveMane());
    }
}
