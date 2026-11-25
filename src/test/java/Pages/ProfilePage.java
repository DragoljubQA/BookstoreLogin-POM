package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage {

    WebDriver driver;
    WebElement profileName;
    WebElement profileButton;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProfileName() {
        return driver.findElement(By.id("userName-value"));
    }

    public List<WebElement> profileButtons() {
        return driver.findElements(By.id("submit"));
    }

    //------------------

    public String profileNameText() {
        return getProfileName().getText();
    }

    public WebElement logOutButton() {
        for (int i = 0; i < profileButtons().size(); i++) {
            if (profileButtons().get(i).getText().equals("Logout")) {
                return profileButtons().get(i);
            }
        }
        return null;
    }

}
