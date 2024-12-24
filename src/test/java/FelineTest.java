


import com.example.Feline;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {

        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));


        Feline feline = new Feline(predatorMock);
        List<String> food = feline.eatMeat();


        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(predatorMock).eatMeat(); // Verify that eatMeat() was called
    }

    @Test
    public void testGetFamily() {
        Predator predatorMock = mock(Predator.class);
        Feline feline = new Feline(predatorMock);
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Predator predatorMock = mock(Predator.class);
        Feline feline = new Feline(predatorMock);
        assertEquals(1, feline.getKittens());
    }
}