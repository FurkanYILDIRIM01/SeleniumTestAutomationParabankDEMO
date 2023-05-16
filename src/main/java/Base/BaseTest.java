package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends BaseLib{
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String Tarayici = System.getProperty("browser");
        String OsName = System.getProperty("os.name");
        if (Tarayici == null) {Tarayici = "Chrome";}

        System.out.println(OsName);
        System.out.println(Tarayici);
        if (Tarayici.equals("Chrome")) {
            if (OsName.equals("Windows 10")) {
                System.setProperty("web driver.chrome.driver", "driver/chromedriver.exe");
            } else {
                System.setProperty("web driver.chrome.driver", "driver/chromedriver");
            }
            driver = new ChromeDriver();
        }
        else{
            if (OsName.equals("Windows 10")) {
                System.setProperty("web driver.gecko.driver", "driver/geckodriver");
            } else {
                System.setProperty("web driver.chrome.driver", "driver/geckodriver.exe");
            }driver = new FirefoxDriver();
        }

        driver.get("https://parabank.parasoft.com");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterDown(){
        driver.quit();

    }
}
