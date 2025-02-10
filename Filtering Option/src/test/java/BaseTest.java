import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest extends Base {

    @BeforeAll
    static void setUp() {
        initializeDriver();
    }

    @AfterAll
    static void tearDown() {
        closeDriver();
    }
}
