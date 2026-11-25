package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;
    WebElement cards;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCards() {
        return driver.findElements(By.className("card-body"));
    }

    //---------------------------

    public void clickOnCard(String cardName) throws InterruptedException {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals(cardName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getCards().get(i));
                Thread.sleep(1000);
                getCards().get(i).click();
                break;
            }
        }
    }

}
