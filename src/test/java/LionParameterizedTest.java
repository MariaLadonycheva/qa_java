import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

public class LionParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    public void testLionSex(String sex) throws Exception {
        Predator predatorMock = mock(Predator.class);
        Lion lion = new Lion(sex, predatorMock);
        Assertions.assertNotNull(lion);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестный", "Некорректный"})
    public void testInvalidSexThrowsException(String invalidSex) {
        Predator predatorMock = mock(Predator.class);
        Exception exception = assertThrows(Exception.class, () ->
        {
            new Lion(invalidSex, predatorMock);
        });
        Assertions.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
