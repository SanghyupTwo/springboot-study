import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {
    @BeforeEach
    public void beforeEach() {
        System.out.println("Hello!");
    }

    @DisplayName("첫 번째 테스트")
    @Test
    public void junitQuiz3() {
        System.out.println("This is first test");
    }

    @DisplayName("두 번째 테스트")
    @Test
    public void junitQuiz4() {
        System.out.println("This is second test");
    }

    @AfterAll
    static public void afterAll() {
        System.out.println("Bye!");
    }
}
