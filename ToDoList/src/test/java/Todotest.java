import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

public class Todotest extends BaseTest {
    @Test
    void addtask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addTask("Driving");
    }
}
