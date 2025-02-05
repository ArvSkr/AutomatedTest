import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Todotest extends BaseTest {
    @Test
    void addtask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addTask("Driving");

    }
    @Test
    void markTaskCompleted() {
        MainPage mainPage = new MainPage(driver);
        String taskName = "Read Book";
        mainPage.addTask(taskName);
        mainPage.markTaskAsCompleted(taskName);

        Assertions.assertTrue(mainPage.isTaskCompleted(taskName), "Task was not marked as completed");
    }
    @Test
    void deleteTask() {
        MainPage mainPage = new MainPage(driver);

        mainPage.addTask("Grocery Shopping");
        mainPage.deleteTask("Grocery Shopping");

        Assertions.assertTrue(mainPage.isTaskDeleted("Grocery Shopping"), "Task was not deleted successfully");
    }
    @Test
    void editTask() {
        MainPage mainPage = new MainPage(driver);
        String oldTask = "Exercise";
        String newTask = "Morning Exercise";
        mainPage.addTask(oldTask);
        mainPage.editTask(oldTask, newTask);

        Assertions.assertTrue(mainPage.isTaskDisplayed(newTask), "Task was not updated successfully");
    }
    @Test
    void addMultipleTasks() {
        MainPage mainPage = new MainPage(driver);
        String[] tasks = {"Read", "Write", "Jog"};

        for (String task : tasks) {
            mainPage.addTask(task);
        }

        Assertions.assertEquals(tasks.length, mainPage.getTaskCount(), "Task count mismatch");
    }
    @Test
    void checkIfTaskExistAfterRefresh() {
        MainPage mainPage = new MainPage(driver);
        String taskName = "Meditation";
        mainPage.addTask(taskName);
        driver.navigate().refresh();

        Assertions.assertTrue(mainPage.isTaskDisplayed(taskName), "Task did not persist after refresh");
    }
}
