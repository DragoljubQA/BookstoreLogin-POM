package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SidebarPage {

    WebDriver driver;
    WebElement sidebarButtons;
    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSidebarButtons() {
        return driver.findElements(By.className("text"));
    }

    //---------------------------

    public void clickOnButton(String buttonName) throws InterruptedException {
        for (int i = 0; i < getSidebarButtons().size(); i++) {
            if (getSidebarButtons().get(i).getText().equals(buttonName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getSidebarButtons().get(i));
                Thread.sleep(1000);
                getSidebarButtons().get(i).click();
                break;
            }
        }
    }

}
