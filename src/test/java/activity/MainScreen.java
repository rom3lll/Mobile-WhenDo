package activity;

import controlAppium.Button;
import controlAppium.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.net.MalformedURLException;
import java.util.List;

public class MainScreen {
    public Button addTaskButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public Label nameTaskLabel = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
    public Label emptyTaskLabel = new Label(By.id("com.vrproductiveapps.whendo:id/noNotesText"));

    public Boolean isCheckItemsListEmpty() throws MalformedURLException {
        if (countItemsAdded() == 0) {
            return true;
        }
        return false;
    }

    public WebElement getItemByTittle(String titleText) throws MalformedURLException {
        WebElement element = Session.getInstance().getDriver().findElement(By.linkText(titleText));
        return element;
    }

    public Button getLastItemAdded() throws MalformedURLException {
        String lastItem = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[%s]", Integer.toString(countItemsAdded()));
        return new Button(By.xpath(lastItem));
    }

    public int countItemsAdded() throws MalformedURLException {
        List<WebElement> list = Session.getInstance().getDriver().findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup"));
        return list.size();
    }

    public MainScreen() {}
}
