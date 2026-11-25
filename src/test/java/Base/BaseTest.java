package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

}
