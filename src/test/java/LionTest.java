

import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void testLionWithMaleSex() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.getKittens()).thenReturn(2);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predatorMock);
        assertTrue(lion.doesHaveMane());
        assertEquals(2, lion.getKittens());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testLionWithFemaleSex() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.getKittens()).thenReturn(3);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", predatorMock);
        assertFalse(lion.doesHaveMane());
        assertEquals(3, lion.getKittens());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testInvalidSexThrowsException() {
        Predator predatorMock = mock(Predator.class);
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный", predatorMock);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}