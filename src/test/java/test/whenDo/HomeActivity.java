package test.whenDo;

import activity.AlertScreen;
import activity.CreateTaskScreen;
import activity.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.net.MalformedURLException;

public class HomeActivity {

    private MainScreen mainScreen = new MainScreen();
    private CreateTaskScreen createTaskScreen = new CreateTaskScreen();
    private AlertScreen alertScreen = new AlertScreen();

    @Test
    public void Should_CreateUpdateDeleteTask() throws MalformedURLException {
        // Data Task
        String titleText = "Math";
        String descriptionText = "Solve";
        String titleUpdateText = "History";
        String descriptionUpdateText = "Century";
        // Create Task
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.typeValue(titleText);
        createTaskScreen.descriptionTextBox.typeValue(descriptionText);
        createTaskScreen.saveButton.click();
        // Update Task
        mainScreen.getLastItemAdded().click();
        createTaskScreen.titleTextBox.clearValue();
        createTaskScreen.titleTextBox.typeValue(titleUpdateText);
        createTaskScreen.descriptionTextBox.clearValue();
        createTaskScreen.descriptionTextBox.typeValue(descriptionUpdateText);
        createTaskScreen.saveButton.click();
        // Delete Task
        mainScreen.getLastItemAdded().click();
        createTaskScreen.deleteButton.click();
        alertScreen.deleteButton.click();

        boolean actualResult = mainScreen.isCheckItemsListEmpty();
        boolean expectedResult = true;
        Assertions.assertEquals(expectedResult, actualResult, "Task has not been deleted.");
    }

    @Test
    public void Should_CreateTask() throws MalformedURLException {
        String titleText = "Math";
        String descriptionText = "Solve";

        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.typeValue(titleText);
        createTaskScreen.descriptionTextBox.typeValue(descriptionText);
        createTaskScreen.saveButton.click();

        String actualResult = mainScreen.nameTaskLabel.getText();
        String expectedResult = titleText;
        Assertions.assertEquals(expectedResult, actualResult, "Task has not been created.");
    }

    @Test
    public void Should_DeleteTask() throws MalformedURLException {
        String titleText = "Math";
        String descriptionText = "Solve";

        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.typeValue(titleText);
        createTaskScreen.descriptionTextBox.typeValue(descriptionText);
        createTaskScreen.saveButton.click();
        mainScreen.getLastItemAdded().click();
        createTaskScreen.deleteButton.click();
        alertScreen.deleteButton.click();


        boolean actualResult = mainScreen.isCheckItemsListEmpty();
        boolean expectedResult = true;
        Assertions.assertEquals(expectedResult, actualResult, "Task has not been deleted.");
    }

    @AfterEach
    public void close() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
